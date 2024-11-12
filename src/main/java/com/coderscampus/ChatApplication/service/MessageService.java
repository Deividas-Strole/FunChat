package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MessageService {

    MessageRepository messageRepository = new MessageRepository();

    public ArrayList<Message> getAllMessages(String channel) {
        return messageRepository.listOfMessagesByChannel(channel);
    }

    public void saveMessage (Message message, String channel) {
        messageRepository.addMessageToArray(message, channel);
    }
}
