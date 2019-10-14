package com.gym.javavalidatedform.controller;


import com.gym.javavalidatedform.model.User;
import com.gym.javavalidatedform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        } else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("firstName",user.getFirstName());
            modelAndView.addObject("lastName",user.getLastName());
            modelAndView.addObject("phoneNumber",user.getPhoneNumber());
            modelAndView.addObject("age",user.getAge());
            modelAndView.addObject("email",user.getEmail());
            modelAndView.addObject("message","New user created successfully");
            return modelAndView;
        }
    }
    @GetMapping("/users")
    public ModelAndView showList(@PageableDefault(size = 2)Pageable pageable){
            Page<User> users = userService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("users", users);
            return modelAndView;
        }
}
