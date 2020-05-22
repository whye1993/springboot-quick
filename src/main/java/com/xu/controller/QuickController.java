package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

//使用Thymeleaf不能使用@RestController
@Controller
public class QuickController {

    @GetMapping("/get")
    public String get(ModelMap modelMap){
        modelMap.put("hello", "hello");
        return "index";
    }
}
