package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatApplicationController {

    @Autowired
    MessageService messageService;


    //String yourName;

    @GetMapping("/welcome")
    private String welcome() {
        return "welcome";
    }

//    @PostMapping("/channels")
//    private String channels(@RequestBody User user, ModelMap model) {
//        yourName = user.getName();
//        System.out.println("yourName in PostMapping (1st func) == " + yourName);
//        return "redirect:/channels";
//    }
//
//    @GetMapping("/channels")
//    private String getChannels(ModelMap model) {
//        System.out.println("yourName in GetMapping (2nf func) == " + "yourName");
//        model.put("name", "yourName");
//        return "channels";
//    }

    @PostMapping("/channels")
    private String channels(@RequestBody User user, ModelMap model) {
        String yourName = user.getName();
        System.out.println("yourName in Controller (PostMaping - channels) " + yourName);
        model.put("name", yourName);

        return "/channels";
    }


    @PostMapping("/channels2")
    private String cannels2(@RequestBody Message message, ModelMap model) {
        System.out.println("****** we are in channels2!!!!");
        System.out.println("Channels2 Textas: " + message.getMessageText());
        System.out.println("Channels2 Name:" + message.getMessageUser());
        //System.out.println("message list in controller before sending back to frontend: " + messageService.saveMessage(message));

************************* start here *** correct passing data from back end to front end ******* D O M
        model.put("listOfMessages", messageService.saveMessage(message));
        return "channels";
    }

    @GetMapping("/test")
    private String test() {
        return "test";
    }

}
