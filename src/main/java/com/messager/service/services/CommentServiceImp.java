package com.messager.service.services;

import com.messager.service.com.messager.service.model.Comment;
import com.messager.service.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CommentServiceImp implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImp(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Comment> findAllComments(Long messageId) {
         Set<Comment> comments = new HashSet<>();
         commentRepository.findByMessageId(messageId).forEach(comments::add);
         return comments;

    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment, Long id) {
        comment.setId(id);
        commentRepository.save(comment);

    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
