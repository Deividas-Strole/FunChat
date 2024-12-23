package com.coderscampus.ChatApplication.domain;

public class Message {

    String name;
    String messageText;

    public Message(String name, String messageText) {
        this.name = name;
        this.messageText = messageText;
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


    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }

}
