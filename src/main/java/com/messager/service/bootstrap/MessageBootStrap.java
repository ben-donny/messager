package com.messager.service.bootstrap;

import com.messager.service.com.messager.service.model.Comment;
import com.messager.service.com.messager.service.model.Message;
import com.messager.service.repositories.MessageRepository;
import com.messager.service.services.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;


@Component
public class MessageBootStrap implements CommandLineRunner{

   private final MessageRepository messageRepository;
    //private final MessageService messageService;



    public MessageBootStrap(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Message Data!!!");

        Message m1 = new Message();
        m1.setMessage("I Love Java");
        m1.setAuthor("Benito Musolini");
        m1.setCreated(LocalDate.now());


        Message m2 = new Message();
        m2.setMessage("I Love SpringFrameWork");
        m2.setAuthor("Ben Doni");
        m2.setCreated(LocalDate.now());

        Message m3 = new Message();
        m3.setMessage("I Love Building Restful Services");
        m3.setAuthor("Doni B");
        m3.setCreated(LocalDate.now());

        Comment c1 = new Comment();

        c1.setAuthor("GodsLove");
        c1.setComment("Testing Entity Relationship");
        c1.setCreated(LocalDate.now());


        Comment c2 = new Comment();
        c2.setAuthor("Micheal");
        c2.setComment("Benito the Genius");
        c2.setCreated(LocalDate.now());



        Comment c3 = new Comment();
        c3.setAuthor("Jonathan");
        c3.setComment("Outstanding Speaker");
        c3.setCreated(LocalDate.now());

        Comment c4 = new Comment();
        c3.setAuthor("Samuel");
        c3.setComment("Property Investor");
        c3.setCreated(LocalDate.now());

        Comment c5 = new Comment();
        c3.setAuthor("Jerry");
        c3.setComment("Too much");
        c3.setCreated(LocalDate.now());

        Comment c6 = new Comment();
        c3.setAuthor("Rustam");
        c3.setComment("Kind Dude!");
        c3.setCreated(LocalDate.now());


        m1.setComments(new HashSet<Comment>() {{
           add(c1);
           add(c2);
       }} );

       m2.setComments(new HashSet<Comment>(){{
           add(c3);
           add(c4);
       }});

        m3.setComments(new HashSet<Comment>(){{
            add(c5);
            add(c6);
        }});


        messageRepository.save(m1);
        messageRepository.save(m2);
        messageRepository.save(m3);
        System.out.println("Message Saved: " + messageRepository.count());


    }
}
