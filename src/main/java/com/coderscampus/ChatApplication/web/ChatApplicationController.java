package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.ChannelRequest;
import com.coderscampus.ChatApplication.domain.DataRequest;
import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.service.ChannelService;
import com.coderscampus.ChatApplication.service.MessageService;
import com.coderscampus.ChatApplication.service.UserService;

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

    @PostMapping("/channels")
    public String getChannel(@RequestParam("channel") String channel, @RequestParam("name") String name, @RequestParam("isNew") Boolean isNew,ModelMap model) {
        System.out.println("isNew in /channels: " + isNew);


//        if (isNew == false) {
//            model.addAttribute("listOfMessages", channelService.getAllMessages(channel));
//        }
        Long userId = userService.createUser(name, channel);
        if (userId == 0L) {
            model.addAttribute("name", name);
            return "welcome";
        }
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