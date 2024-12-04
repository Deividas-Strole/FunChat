package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.MessageOld;
import com.coderscampus.ChatApplication.repository.MessageRepositoryOld2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MessageService2 {

    private final MessageRepositoryOld2 messageRepository;

    public MessageService2(MessageRepositoryOld2 messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ArrayList<MessageOld> getAllMessages(String channel) {
        return messageRepository.listOfMessagesByChannel(channel);
    }

    public void saveMessage (MessageOld message, String channel) {
        messageRepository.addMessageToArray(message, channel);
    }
}
