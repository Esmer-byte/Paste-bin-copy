package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.Insert;

import java.sql.*;

@Controller
public class WebController {

    user User;
    @Autowired
    Repository Repository;

    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("user", new user());
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute user user, Model model) throws SQLException {
        model.addAttribute("user", user);
        String info = String.format("user Submission: username = %s, password = %s", user.getUserName(), user.getPassword());
        Repository.save(user);
        User = user;
        Insert insert = new Insert();
        insert.insertValues(User);
        return "result";
    }

    @RequestMapping(value="/")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/user")
    public String user(){
        return "user";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}