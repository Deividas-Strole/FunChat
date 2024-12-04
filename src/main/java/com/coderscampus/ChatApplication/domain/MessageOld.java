package com.coderscampus.ChatApplication.domain;

import java.util.Objects;

public class MessageOld {

    //id
    //user
    //content
    //channel id

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOld message = (MessageOld) o;
        return Objects.equals(messageUser, message.messageUser) && Objects.equals(messageText, message.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageUser, messageText);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", messageUser=" + messageUser +
                '}';
    }
}
