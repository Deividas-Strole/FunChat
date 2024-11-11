package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MessageRepository {

    private final HashMap<String, ArrayList<Message>> channelMessages = new HashMap<>();

    public void addMessageToArray(Message message, String channel) {
        channelMessages.computeIfAbsent(channel, k -> new ArrayList<>()).add(message);

        System.out.println("message user in repo: " + message.getMessageUser());
        System.out.println("message message in repo: " + message.getMessageText());
        System.out.println("channel in repo: " + channel);
    }

    public ArrayList<Message> listOfMessagesByChannel(String channel) {
        return channelMessages.getOrDefault(channel, new ArrayList<>());
    }
}
