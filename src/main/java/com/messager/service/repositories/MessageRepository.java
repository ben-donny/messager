package com.messager.service.repositories;

import com.messager.service.com.messager.service.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
