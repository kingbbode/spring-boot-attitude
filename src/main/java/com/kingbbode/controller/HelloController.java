package com.kingbbode.controller;

import com.kingbbode.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by YG-MAC on 2017. 3. 25..
 */
@Controller
public class HelloController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "hello";
    }
}
