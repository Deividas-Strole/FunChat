package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.Message;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MessageService {

    ArrayList<Message> listOfMessages = new ArrayList<Message>();

    public List<Message> saveMessage(Message message) {
        listOfMessages.add(message);
        System.out.println("Message in MessageService: " + message);
        return listOfMessages;
    }

    public List<Message> getAllMessage() {
        return listOfMessages;
    }
}
