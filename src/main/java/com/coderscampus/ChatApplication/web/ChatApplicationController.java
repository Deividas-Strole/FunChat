package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.ChannelRequest;
import com.coderscampus.ChatApplication.domain.DataRequest;
import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.service.ChannelService;
import com.coderscampus.ChatApplication.service.MessageService;
import com.coderscampus.ChatApplication.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatApplicationController {

    private final MessageService messageService;
    private final UserService userService;
    private final ChannelService channelService;

    public ChatApplicationController(MessageService messageService, UserService userService, ChannelService channelService) {
        this.messageService = messageService;
        this.userService = userService;
        this.channelService = channelService;
    }

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }


    @PostMapping("/checkDuplicate")
    @ResponseBody
    private ResponseEntity checkForDuplicateNames(@RequestParam("name") String name, @RequestParam("channel") String channel) {
        System.out.println("name and channel in controller from js: " + name + channel);
        //boolean isDuplicate = userService.checkForDuplicateName(name, channel);
        //return ResponseEntity.ok().body();
        boolean result = userService.checkForDuplicateName(name, channel);
        System.out.println("result in controller: " + result);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/channels")
    public String redirectToWelcome() {
        return "welcome";
    }


    @PostMapping("/channels")
    public String getChannel(@RequestParam("channel") String channel, @RequestParam("name") String name, @RequestParam("isNew") Boolean isNew,ModelMap model, HttpSession session) {
        System.out.println("isNew in /channels: " + isNew);
        Long userId = userService.createUser(name, channel);
        session.setAttribute("name", name);
        return "redirect:/channels/" + channel;
    }

    @GetMapping("/channels/{channel}")
    public String redirectToChannel(@PathVariable String channel, HttpSession session, ModelMap model) {
        String name = (String) session.getAttribute("name");
        System.out.println("name in redirect getmapping: " + name);
        model.addAttribute("name", name);
        model.addAttribute("channel", channel);
        return "channels";
    }

    @PostMapping("/postDataToServer")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody DataRequest dataRequest, ModelMap model) {
        String channel = dataRequest.getChannel();
        Message message = dataRequest.getMessage();
        channelService.addToChannel(channel, message);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/returnAllMessages")
    @ResponseBody
    private ResponseEntity <List<Message>>returnAllMessages(ModelMap model, @RequestBody ChannelRequest channelRequest) {
        String channel = channelRequest.getChannel();
        ArrayList<Message> listOfMessages = channelService.getAllMessages(channel);
        return ResponseEntity.ok().body(listOfMessages);
    }
}