package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChatApplicationController {

    @Autowired
    MessageService messageService;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @GetMapping("/channels")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model) {
        List<Message>  listOfMessages = messageService.getAllMessage();
        return ResponseEntity.ok().body(listOfMessages);
    }

    @PostMapping("/channels")
    private String channels(@RequestBody User user, ModelMap model) {
        String yourName = user.getName();
        model.put("name", yourName);
        return "/channels";
    }

    @PostMapping("/channels2")
    @ResponseBody
    private ResponseEntity cannels2(@RequestBody Message message, ModelMap model) {
        List<Message>  listOfMessages = messageService.saveMessage(message);
        return ResponseEntity.ok().body(listOfMessages);
    }
}
