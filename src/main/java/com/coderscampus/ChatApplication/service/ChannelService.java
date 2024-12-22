package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.MessageOld;
import com.coderscampus.ChatApplication.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;
    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    GOT STUCK HERE BELOW

    public void addToChannel(String channel, Message message) {
        channelRepository.addMessageToArray(channel, message);
    }

    public ArrayList<Message> getAllMessages(String channel) {
        return channelRepository.listOfMessagesByChannel(channel);
    }


}
