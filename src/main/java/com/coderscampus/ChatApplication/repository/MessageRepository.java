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

        if (chanellMessages.containsKey(channel)) {
            chanellMessages.get(channel).add(message);
        } else {
            listOfMessages.add(message);
            chanellMessages.put(channel, listOfMessages);
        }

        System.out.println("message user in repo: " + message.getMessageUser());
        System.out.println("message message in repo: " + message.getMessageText());
        System.out.println("channel in repo: " + channel);

        //chanellMessages.put(channel, message);

        //chanellMessages.get(channel).add(message);

    }

    public ArrayList<Message> listOfMessagesByChannel(String channel) {

        if (chanellMessages.containsKey(channel)) {
            return chanellMessages.get(channel);
        } else {
            return listOfMessages;
        }
        //return  chanellMessages.get(channel);
    }
}
