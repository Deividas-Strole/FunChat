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

    @GetMapping("/channels")
    public String getChannel(@RequestParam("channel") String channel, @RequestParam("name") String name, ModelMap model) {
        Long userId = userService.createUser(name);
        Message emptyMessage = new Message(userId, null, null);
        channelService.addToChannel(channel, emptyMessage);

        model.addAttribute("name", name);
        model.addAttribute("channel", channel);
        return "channels";
    }

    @PostMapping("/postDataToServer")
    @ResponseBody
    private ResponseEntity postDataToServer(@RequestBody Message message, ModelMap model) {
        channelService.addToChannel(message.getChannel(), message);
        //messageService.saveMessage(message, channel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/returnAllMessages/{channel}")
    @ResponseBody
    private ResponseEntity returnAllMessages(ModelMap model, @PathVariable String channel) {
        List<Message> listOfMessages = channelService.getAllMessages(channel);
        return ResponseEntity.ok().body(listOfMessages);
    }
}