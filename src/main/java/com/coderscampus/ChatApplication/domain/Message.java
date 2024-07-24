package com.coderscampus.ChatApplication.domain;

public class Message {

    String messageUser;
    String messageText;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", messageUser=" + messageUser +
                '}';
    }
}
