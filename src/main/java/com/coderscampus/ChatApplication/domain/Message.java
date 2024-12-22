package com.coderscampus.ChatApplication.domain;

import java.util.Objects;

public class Message {

    //id
    //user
    //content
    //channel id

    //String messageUser;
    //Long userId;

    String name;
    String messageText;
    String channel;

    public Message(String name, String messageText, String channel) {
        this.name = name;
        this.messageText = messageText;
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", messageText='" + messageText + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }

    //    public String getMessageUser() {
//        return messageUser;
//    }
//
//    public void setMessageUser(String messageUser) {
//        this.messageUser = messageUser;
//    }



}
