package com.messager.service.services;

import com.messager.service.com.messager.service.model.Message;
import com.messager.service.repositories.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message findMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> findAllMessages() {

        List<Message> messages = new ArrayList<>();
        messageRepository.findAll().iterator().forEachRemaining(messages::add);
        return messages;
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void updateMessage(Message message, Long id) {
        message.setId(id);
        messageRepository.save(message);

    }

    @Override
    public void deleteMessage(Long id) {
     messageRepository.deleteById(id);
    }
}
