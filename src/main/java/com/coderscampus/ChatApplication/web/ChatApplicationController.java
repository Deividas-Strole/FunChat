package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.MessageOld;

import com.coderscampus.ChatApplication.service.ChannelService;
import com.coderscampus.ChatApplication.service.MessageService;
import com.coderscampus.ChatApplication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
    public String getChannel(@RequestParam("channel") String channel, @RequestParam("name") String name, ModelMap model) {
        //System.out.println("channel and name: " + channel + name);
        Long userId = userService.createUser(name);
        //System.out.println("userId: " + userId);
        Message emptyMessage = new Message(name, null, null);
        //System.out.println("empty mess: " + emptyMessage);
        channelService.addToChannel(channel, emptyMessage);
       // System.out.println("name and channel: " + name + channel);
        model.addAttribute("name", name);
        model.addAttribute("channel", channel);
        return "channels";
    }

    @PostMapping("/postDataToServer")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody Message message, ModelMap model) {
        System.out.println("name, text, channel: " + message.getName() + message.getMessageText() + message.getChannel());
        channelService.addToChannel(message.getChannel(), message);
        //messageService.saveMessage(message, channel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/returnAllMessages")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model, @RequestBody String channel) {
        List<Message> listOfMessages = channelService.getAllMessages(channel);
        return ResponseEntity.ok().body(listOfMessages);
    }
}