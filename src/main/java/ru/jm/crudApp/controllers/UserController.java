package ru.jm.crudApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.jm.crudApp.models.User;
import ru.jm.crudApp.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("AllUsers", userService.getAllUsers());
        return "first/index";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "first/addNewUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "first/addNewUser";
        }

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editUser(@PathVariable(name = "id") int id, Model model) {

        model.addAttribute("user", userService.getUser(id));
        return "first/update";
    }

    @PatchMapping(value = "/update/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "first/update";
        }

        userService.updateUser(id, user);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomerForm(@PathVariable(name = "id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}