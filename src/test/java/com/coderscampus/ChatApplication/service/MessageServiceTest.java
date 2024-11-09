//package com.coderscampus.ChatApplication.service;
//
//import com.coderscampus.ChatApplication.domain.Message;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
//class MessageServiceTest {
//
//    Message message = new Message();
//    Message  expectedResultMessage = new Message();
//    MessageService messageService = new MessageService();
//    List<Message> actualResult;
//    List<Message> expectedResult = new ArrayList<>();
//
//    @BeforeEach
//    void prepData() {
//
//        message.setMessageUser("TestUser");
//        message.setMessageText("Test Text");
//        actualResult = messageService.saveMessage(message, channel);
//
//        expectedResultMessage.setMessageUser("TestUser");
//        expectedResultMessage.setMessageText("Test Text");
//
//        expectedResult.add(expectedResultMessage);
//    }
//
//    @Test
//    void saveMessageTest() {
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    void getAllMessages() {
//        assertEquals(expectedResult, actualResult);
//    }
//}