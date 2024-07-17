package com.coderscampus.ChatApplication.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatApplicationController {

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @PostMapping ("/channels")
    private String channels(@RequestBody String name) {
        System.out.println("Name: " + name);
        return "channels";
    }
}
