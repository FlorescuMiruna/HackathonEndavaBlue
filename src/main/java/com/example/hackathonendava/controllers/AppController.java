package com.example.hackathonendava.controllers;

import com.example.hackathonendava.registration.User;
import com.example.hackathonendava.registration.UserRepository;
import com.example.hackathonendava.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    private String currentUser = "none";

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TaskRepository taskRepo;

    private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    @GetMapping("")
    public String viewHomePage(User user) {
        return "home_page";
    }

    @GetMapping("/home")
    public String viewHome() {
        return "home_page";
    }

    @GetMapping("/notes")
    public String viewNotes(User user) {

        return "notes";
    }

    @GetMapping("/deadlines")
    public String viewDeadlines() {
        return "tasks";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register_form";
    }
    @GetMapping("/login_page")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login_page";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        System.out.println(user.getEmail());
        user.setEnabled(true);
        userRepo.save(user);

        return "register_succes";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        //List<User> listUsers = userRepo.findAll();
        //model.addAttribute("listUsers", listUsers);
        //return "users_list";
        return null;
    }



//    @GetMapping("/tasks")
//    public String listTasks(Model model) {
//        List<Task> listTasks = taskRepo.findAll();
//        model.addAttribute("listTasks", listTasks);
//        return "tasks_list";
//    }

//    @GetMapping("/new_task")
//    public String showNewTaskForm(Model model) {
//        model.addAttribute("task", new Task());
//
//        return "new_task_form";
//    }

//    @PostMapping("/process_new_task")
//
//    public String processNewTask(Task task) {
//        task.setStage("To do");
//        taskRepo.save(task);
//        return "new_task_succes";
//
//    }
//
//



}
