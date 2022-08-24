package com.example.pp311.controller;

import com.example.pp311.model.User;
import com.example.pp311.service.UserService;
import com.example.pp311.service.User_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final User_Service userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/")
    public String findAll(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }

    @GetMapping("/userCreate")
    public String createUserForm(User user) {
        return "userCreate";
    }

    @PostMapping("userCreate")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("userDelete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("userUpdate/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.showUserById(id);
        model.addAttribute("user", user);
        return "/userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser(User user) {
        int id =user.getId();
        userService.update(id, user);
        return "redirect:/";
    }

}

