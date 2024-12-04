package com.coderscampus.ChatApplication.domain;

public class Channel {
    Long channelId;
    String channelName;
    String userId;

    //id
    //name
    //list of msgs

    public Channel(Long channelId, String channelName, String userId) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.userId = userId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
