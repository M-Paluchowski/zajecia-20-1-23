package com.javastart.demo.exercises.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @GetMapping("/users")
    String users() {
        List<User> users = userRepository.getAll();

        String result = "";

        for (User user : users) {
            result += user.toString() + "</br>";
        }

        return result;
    }

    @GetMapping("/add")
    public String add(@RequestParam String name, @RequestParam String lastName, @RequestParam int age) {

        if ("".equals(name)) {
            return "redirect:/err.html";
        } else {
            User user = new User(name, lastName, age);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }
}
