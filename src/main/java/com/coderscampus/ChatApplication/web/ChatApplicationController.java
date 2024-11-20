package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ChatApplicationController {

    private final MessageService messageService;

    public ChatApplicationController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @GetMapping("/channels")
    public String getChannel(@RequestParam("channel") String channel, @RequestParam("name") String name, ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("channel", channel);
        return "channels";
    }

    @PostMapping("/postDataToServer/{channel}")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody Message message, ModelMap model, @PathVariable String channel) {
        messageService.saveMessage(message, channel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/returnAllMessages/{channel}")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model, @PathVariable String channel) {
        List<Message> listOfMessages = messageService.getAllMessages(channel);
        return ResponseEntity.ok().body(listOfMessages);
    }
}
