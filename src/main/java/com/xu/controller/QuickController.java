package com.xu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {

    @GetMapping("/get")
    public String get(){
        return "I don't you want to get something?";
    }
}
