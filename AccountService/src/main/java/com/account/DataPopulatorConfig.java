package com.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.account.model.User;
import com.account.service.UserService;

// config files got called first and commandline configurations are called later
@Configuration
public class DataPopulatorConfig implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("1", "abc.gmail.com", "abc");
//        userService.createUser(user);
    }
}
