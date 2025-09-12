package com.wipro.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.model.User;
import com.wipro.web.UserDao;

@Controller
public class UserController {

@Autowired
private UserDao userDao;

@RequestMapping("/signin")
public String showForm() {
    return "signin";
}

@PostMapping("/saveUser")
public String saveUser(@ModelAttribute("user") User user, HttpServletRequest req) {
    userDao.saveUser(user);
    req.setAttribute("username", user.getUsername());
    return "success";
}


}