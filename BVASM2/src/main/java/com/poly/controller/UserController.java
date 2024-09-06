package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.poly.Service.UserService;
import com.poly.entity.User;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String viewUsersPage(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("user", new User());
        return "USER";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") String id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "USER";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/users/reset")
    public String resetForm(Model model) {
        model.addAttribute("user", new User());
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "USER";
    }
    @GetMapping("/users/search")
    public String searchUserById(@RequestParam("id") String id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            model.addAttribute("error", "User not found with ID: " + id);
        } else {
            model.addAttribute("userList", List.of(user)); // Đưa user vào danh sách để hiển thị
        }
        model.addAttribute("user", new User()); // Để hiển thị lại form
        return "user";
    }

}
