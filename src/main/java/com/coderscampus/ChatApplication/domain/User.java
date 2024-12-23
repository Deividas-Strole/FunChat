package com.coderscampus.ChatApplication.domain;

import java.util.concurrent.atomic.AtomicLong;

public class User {

    private static final AtomicLong counter = new AtomicLong(1);
    private final Long userId;
    private String userName;


    public User(String userName) {
        this.userId =counter.getAndIncrement();
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
