package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.MessageService;
import com.coderscampus.ChatApplication.service.UserService;
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
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @PostMapping("/channels/{channel}")
    public String saveUserToDB(@RequestBody User user, @PathVariable String channel) {

        userService.createUser(user, channel);
//        visitorsName = user.getName();
//        userId++;
//        user.setId(userId);
//        user.setChannel(channel);
        return "redirect:/channels/{channel}";
    }

    @GetMapping("/channels/{channel}")
    public String getChannel(ModelMap model, @PathVariable String channel) {
        //messageService.getAllMessages(channel);
        model.addAttribute("name", visitorsName);
        model.addAttribute("channel", channel);
        return "channels";
    }

    @PostMapping("/postDataToServer/{channel}")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody Message message, ModelMap model , @PathVariable String channel) {
        messageService.saveMessage(message, channel);
        return ResponseEntity.ok().body(messageService.getAllMessages(channel));
    }

    @GetMapping("/returnAllMessages/{channel}")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model, @PathVariable String channel) {
        List<Message> listOfMessages = messageService.getAllMessages(channel);
        return ResponseEntity.ok().body(listOfMessages);
    }
}
