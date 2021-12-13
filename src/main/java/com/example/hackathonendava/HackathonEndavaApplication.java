package com.example.hackathonendava;

import com.example.hackathonendava.registration.users.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.*;

@SpringBootApplication
public class HackathonEndavaApplication {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(HackathonEndavaApplication.class.getName());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HackathonEndavaApplication.class, args);

        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(HackathonEndavaApplication.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database");
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        log.info("Database connection test: " + connection.getCatalog());

        log.info("Create database schema");
        Scanner scanner = new Scanner(HackathonEndavaApplication.class.getClassLoader().getResourceAsStream("schema.sql"));
        Statement statement = connection.createStatement();
        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }
    }

    private static void insertData(User user, Connection connection) throws SQLException {
        log.info("Insert data");
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO users (id, email, password, first_name, last_name) VALUES (?, ?, ?, ?,?);");

        insertStatement.setLong(1, user.getId());
        insertStatement.setString(2, user.getEmail());
        insertStatement.setString(3, user.getPassword());
        insertStatement.setString(4, user.getFirstName());
        insertStatement.setString(5, user.getLastName());
        insertStatement.executeUpdate();
    }

    private static User readData(Connection connection) throws SQLException {
        log.info("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM users;");
        ResultSet resultSet = readStatement.executeQuery();
        if (!resultSet.next()) {
            log.info("There is no data in the database!");
            return null;
        }
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("first name"));
        user.setLastName(resultSet.getString("last name"));
        log.info("Data read from the database: " + user.toString());
        return user;
    }

    private static void updateData(User user, Connection connection) throws SQLException {
        log.info("Update data");
        PreparedStatement updateStatement = connection
                .prepareStatement("UPDATE users SET email = ?, password = ?, first_name = ?, last_name = ? WHERE id = ?;");

        updateStatement.setString(1, user.getEmail());
        updateStatement.setString(2, user.getPassword());
        updateStatement.setString(3, user.getFirstName());
        updateStatement.setString(4, user.getLastName());
        updateStatement.setLong(5, user.getId());
        updateStatement.executeUpdate();
        readData(connection);
    }

    private static void deleteData(User user, Connection connection) throws SQLException {
        log.info("Delete data");
        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?;");
        deleteStatement.setLong(1, user.getId());
        deleteStatement.executeUpdate();
        readData(connection);
    }

}
