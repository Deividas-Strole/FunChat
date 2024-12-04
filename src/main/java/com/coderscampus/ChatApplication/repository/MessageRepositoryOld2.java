package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.domain.MessageOld;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MessageRepositoryOld2 {

    private final HashMap<String, ArrayList<MessageOld>> channelMessages = new HashMap<>();

    public void addMessageToArray(MessageOld message, String channel) {
        channelMessages.computeIfAbsent(channel, k -> new ArrayList<>()).add(message);
    }

    public ArrayList<MessageOld> listOfMessagesByChannel(String channel) {
        return channelMessages.getOrDefault(channel, new ArrayList<>());
    }
}
