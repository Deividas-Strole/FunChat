package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageRepository {

    ArrayList<Message> listOfMessages = new ArrayList<Message>();
    HashMap<String, ArrayList<Message>> chanellMessages = new HashMap<String, ArrayList<Message>>();

    public void addMessageToArray(Message message, String channel) {
        //chanellMessages.get(channel);
        //listOfMessages.add(message);

        //chanellMessages.put(channel, "green");

        chanellMessages.get(channel).add(message);

    }

    public ArrayList<Message> listOfMessagesByChannel(String channel) {

        return  chanellMessages.get(channel);
    }
}
