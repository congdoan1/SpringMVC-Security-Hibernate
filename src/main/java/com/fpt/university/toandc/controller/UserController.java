package com.fpt.university.toandc.controller;

import com.fpt.university.toandc.model.User;
import com.fpt.university.toandc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by ToanQri on 9/14/2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/listUsers"})
    public String listStudents(Map<String, Object> map) {
        map.put("users", userService.getAllUsers());
        System.out.println("size: " + userService.getAllUsers().size());
        return "users";
    }

    @RequestMapping(value = "/searchUsers")
    public String listSearchStudents(@RequestParam String termSearchName, Map<String, Object> map) {
        map.put("users", userService.findByUsername(termSearchName));
        return "users";
    }

    @RequestMapping("addUser")
    public ModelAndView createStudent(@ModelAttribute User user) {
        ModelAndView view = new ModelAndView("newForm");
        view.addObject("new", new User());
        return view;
    }

    @RequestMapping(value = "/editUser")
    public ModelAndView editStudent(@RequestParam int userId, @ModelAttribute User user) {
        User u = userService.findById(userId);
        ModelAndView view = new ModelAndView("newForm");
        view.addObject("new", u);
        return view;
    }

    @RequestMapping(value = "/saveUser")
    public String saveStudent(@ModelAttribute User ne) {
        userService.saveUser(ne);
        return "redirect:listUsers";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam int newId) {
        userService.deleteUser(newId);
        return "redirect:listUsers";
    }
}
