package com.messager.service.repositories;

import com.messager.service.com.messager.service.model.Comment;
import org.springframework.data.repository.CrudRepository;


import java.util.Set;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    public Set<Comment> findByMessageId(Long messageId);
}
