package com.coderscampus.ChatApplication.domain;

public class DataRequest {

    private String channel;
    private Message message;

    public DataRequest(String channel, Message message) {
        this.channel = channel;
        this.message = message;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
