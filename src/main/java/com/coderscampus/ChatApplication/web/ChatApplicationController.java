package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.MessageService;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    private HttpSession session;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }



    @PostMapping("/channels")
    public String channelsPost(@RequestBody User user) {
        session.setAttribute("userName", user.getName());
        return "redirect:/channels";
    }

    @GetMapping("/channels")
    public String channelsGet(ModelMap model) {
        String userName = (String) session.getAttribute("userName");
        model.addAttribute("name", userName);
        List<Message> messages = messageService.getAllMessage();
        model.addAttribute("messages", messages);
        return "channels";
    }


    @PostMapping("/channels2")
    @ResponseBody
    private ResponseEntity cannels2(@RequestBody Message message, ModelMap model) {
        List<Message>  listOfMessages = messageService.saveMessage(message);
        return ResponseEntity.ok().body(listOfMessages);
    }

    @GetMapping("/channels3")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model) {
        List<Message>  listOfMessages = messageService.getAllMessage();
        return ResponseEntity.ok().body(listOfMessages);
    }
}
