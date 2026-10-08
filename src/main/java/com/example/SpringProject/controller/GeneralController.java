package com.example.SpringProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/general")
public class GeneralController {
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return "<h1>Hello "+name+"</h1>";
    }

    @GetMapping("/")
    public String welcome(){
        return "<h1>welcome</h1>";
    }

}
