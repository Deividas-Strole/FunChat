package com.coderscampus.ChatApplication.domain;

import java.util.Objects;

public class Message {

    //id
    //user
    //content
    //channel id

    //String messageUser;
    Long userId;
    String messageText;
    String channel;

    public Message(Long userId, String messageText, String channel) {
        this.userId = userId;
        this.messageText = messageText;
        this.channel = channel;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    //    public String getMessageUser() {
//        return messageUser;
//    }
//
//    public void setMessageUser(String messageUser) {
//        this.messageUser = messageUser;
//    }


    @Override
    public String toString() {
        return "Message{" +
                "userId=" + userId +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
