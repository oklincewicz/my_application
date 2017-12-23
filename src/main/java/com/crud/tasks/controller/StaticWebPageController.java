package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


public class StaticWebPageController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("variable", "My Thymeleaf variable");
        model.put("first_request", "2 * 2 = ");
        model.put("second_request", "2 * 2 + 2 = ");
        model.put("third_request", "2 - 2 * 2 = ");
        model.put("two", 2);
        return "index";
    }
}
