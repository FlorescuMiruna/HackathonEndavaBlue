package com.example.hackathonendava.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import java.util.List;

public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() { return (List<User>) userRepository.findAll(); }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new UserInfo(user);
    }

}
