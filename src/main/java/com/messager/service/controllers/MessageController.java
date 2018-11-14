package com.messager.service.controllers;

import com.messager.service.com.messager.service.model.Message;
import com.messager.service.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MessageController.BASE_URL)
public class MessageController {

    public static final String BASE_URL = "api/v1/messages";

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.findAllMessages();
    }

    @GetMapping("/{id}")
    public Message findMessageById(@PathVariable Long id){
        return messageService.findMessageById(id);
    }

    @PostMapping
    public Message saveMessage(@RequestBody Message message){

        return messageService.saveMessage(message);
    }

    @PutMapping("/{id}")
    public void updateMessage(@RequestBody Message message, @PathVariable Long id){

        messageService.updateMessage(message, id);
    }


    @DeleteMapping("{/id}")
    public void deleteMessage(@PathVariable Long id){
        messageService.deleteMessage(id);
    }
}
