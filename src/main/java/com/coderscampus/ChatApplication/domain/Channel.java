package com.coderscampus.ChatApplication.domain;

import java.util.ArrayList;

public class Channel {
    String channel;
    String userId;
    ArrayList<Message> listOfMessages;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(ArrayList<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channel='" + channel + '\'' +
                ", userId='" + userId + '\'' +
                ", listOfMessages=" + listOfMessages +
                '}';
    }
}
