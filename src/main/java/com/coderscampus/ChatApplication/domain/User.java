package com.coderscampus.ChatApplication.domain;

public class User {
    Long userId;
    String userName;
    String channelId;

    public User(Long userId, String userName, String channelId) {
        this.userId = userId;
        this.userName = userName;
        this.channelId = channelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
