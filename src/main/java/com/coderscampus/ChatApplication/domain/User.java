package com.coderscampus.ChatApplication.domain;

public class User {

    Long id;
    String name;
    String channel;

    public User(Long id, String name, String channel) {
        this.id = id;
        this.name = name;
        this.channel = channel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
