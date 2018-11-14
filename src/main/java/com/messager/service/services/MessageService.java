package com.messager.service.services;

import com.messager.service.com.messager.service.model.Message;

import java.util.List;

public interface MessageService {

    Message findMessageById(Long id);

    List<Message> findAllMessages();

    Message saveMessage(Message message);

    void updateMessage(Message message, Long id);

    void deleteMessage(Long id);
}
