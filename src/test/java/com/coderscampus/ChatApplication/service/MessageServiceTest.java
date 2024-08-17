package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @Test
    void saveMessageTest() {
        Message message = new Message();
        message.setMessageUser("TestUser");
        message.setMessageText("Test Text");

        MessageService messageService = new MessageService();

        List<Message> actualResult = messageService.saveMessage(message);

        Message  expectedResultMessage = new Message();
        expectedResultMessage.setMessageUser("TestUser");
        expectedResultMessage.setMessageText("Test Text");

        List<Message> expectedResult = new ArrayList<>();
        expectedResult.add(expectedResultMessage);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getAllMessages() {
    }
}