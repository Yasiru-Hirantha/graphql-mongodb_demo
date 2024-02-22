package com.hsenid.sqldemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
@CrossOrigin
public class Testing {
    @GetMapping
    public String myTest(){
        System.out.println("This is working");
        return "Ok";
    }
}
