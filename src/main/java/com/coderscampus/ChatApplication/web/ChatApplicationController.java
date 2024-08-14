package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.MessageService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
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

//    @GetMapping("/channels")
//    @ResponseBody
//    private ResponseEntity returnAllMessages(ModelMap model) {
//        List<Message>  listOfMessages = messageService.getAllMessage();
//        return ResponseEntity.ok().body(listOfMessages);
//    }

//    @GetMapping("/channelsPage")
//    public String channelsPage(ModelMap model) {
//        // This would return a view named "channels"
//        System.out.println("You are in channelsPage method");
//        return "channels";
//    }


//    @PostMapping("/channels")
//    private String  channels(@RequestBody User user, ModelMap model) {
//        String yourName = user.getName();
//        model.put("name", yourName);
//        //return "redirect/test";
//        //return "redirect:/channels";
//        //return new RedirectView("/channels");
//        //return "channels";
//        return "redirect:/channelsPage";
//    }

//    @GetMapping("/test")
//    private String test() {
//        System.out.println("you are in test method");
//        return "redirect:/channels";
//    }

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
}
