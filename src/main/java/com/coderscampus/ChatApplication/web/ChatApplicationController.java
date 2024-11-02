package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatApplicationController {

    String visitorsName;
    Long userId = 0L;

    @Autowired
    MessageService messageService;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @PostMapping("/channels/{channel}")
    public String channelsPost(@RequestBody User user, @PathVariable String channel) {
        visitorsName = user.getName();
        userId++;
        user.setId(userId);
        user.setChannel(channel);
        return "redirect:/channels/{channel}";
    }

    @GetMapping("/channels/{channel}")
    public String channelsGet(ModelMap model) {
        model.addAttribute("name", visitorsName);
        return "channels";
    }

    @PostMapping("/postDataToServer")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody Message message, ModelMap model) {
        List<Message>  listOfMessages = messageService.saveMessage(message);
        return ResponseEntity.ok().body(listOfMessages);
    }

    @GetMapping("/returnAllMessages")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model) {
        List<Message>  listOfMessages = messageService.getAllMessages();
        return ResponseEntity.ok().body(listOfMessages);
    }
}
