package com.messager.service.services;

import com.messager.service.com.messager.service.model.Comment;

import java.util.Set;

public interface CommentService {

    Comment findCommentById(Long id);

    Set<Comment> findAllComments(Long messageId);

    Comment saveComment(Comment comment);

    void updateComment(Comment comment, Long id);

    void deleteComment(Long id);
}
