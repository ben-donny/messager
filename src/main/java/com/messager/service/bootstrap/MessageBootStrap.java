package com.messager.service.bootstrap;

import com.messager.service.com.messager.service.model.Message;
import com.messager.service.repositories.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageBootStrap implements CommandLineRunner {

    private final MessageRepository messageRepository;

    public MessageBootStrap(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Message Data!!!");

      Date day = new Date();

        Message m1 = new Message();
        m1.setMessage("I Love Java");
        m1.setAuthor("Benito Musolini");
        m1.setCreated(day);
        messageRepository.save(m1);

        Message m2 = new Message();
        m2.setMessage("I Love SpringFrameWork");
        m2.setAuthor("Ben Doni");
        m2.setCreated(day);

        messageRepository.save(m2);


        Message m3 = new Message();
        m3.setMessage("I Love Building Restful Serrvices");
        m3.setAuthor("Doni B");
        m3.setCreated(day);

        messageRepository.save(m3);


        System.out.println("Message Saved: " + messageRepository.count());

    }
}
