package com.coderscampus.ChatApplication.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void setMessageTextAndRetrieveIt() {
        Message message = new Message();
        String expectedText = "Test Message";
        message.setMessageText(expectedText);
        String actualText = message.getMessageText();
        assertEquals(expectedText, actualText);
    }

    @Test
    void setUserAndRetrieveIt() {
        Message message = new Message();
        String expectedUser = "Tester";
        message.setMessageUser(expectedUser);
        String actualUser = message.getMessageUser();
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testToString() {
        Message message = new Message();
        message.setMessageText("Test Message");
        message.setMessageUser("Tester");
        String expectedString = "Message{messageText='Test Message', messageUser=Tester}";
        assertEquals(expectedString, message.toString());
    }
}