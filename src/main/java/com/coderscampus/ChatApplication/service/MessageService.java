package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public ArrayList<Message> getAllMessages(String channel) {
        return messageRepository.listOfMessagesByChannel(channel);
    }




//    ArrayList<Message> listOfMessages = new ArrayList<Message>();
//
//    public List<Message> saveMessage(Message message) {
//        listOfMessages.add(message);
//        return listOfMessages;
//    }
//
//    public List<Message> getAllMessages() {
//        return listOfMessages;
//    }
}
