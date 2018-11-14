package com.messager.service.services;

import com.messager.service.com.messager.service.model.Message;
import com.messager.service.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageImp implements MessageService {

    private final MessageRepository messageRepository;

    public MessageImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message findMessageById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
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
