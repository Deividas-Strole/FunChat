package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.domain.Message;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class ChannelRepository {

    private final HashMap<String, ArrayList<Message>> channelMessages = new HashMap<>();


    public void addMessageToArray(String channel, Message message) {
        if (message != null) {
            channelMessages.computeIfAbsent(channel, k -> new ArrayList<>()).add(message);
        }
    }

    public ArrayList<Message> listOfMessagesByChannel(String channel) {
        return channelMessages.getOrDefault(channel, new ArrayList<>());
    }

}





