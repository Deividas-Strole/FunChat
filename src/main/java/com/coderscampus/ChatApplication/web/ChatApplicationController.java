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

    String visitorsName;

    @Autowired
    MessageService messageService;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

    @PostMapping("/channels")
    public String channelsPost(@RequestBody User user) {
        visitorsName = user.getName();
        return "redirect:/channels";
    }

    @GetMapping("/channels")
    public String channelsGet(ModelMap model) {
        model.addAttribute("name", visitorsName);
        return "channels";
    }

    @PostMapping("/postDataToServer")
    @ResponseBody
    private ResponseEntity cannels2(@RequestBody Message message, ModelMap model) {
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
