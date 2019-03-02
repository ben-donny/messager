package com.messager.service.controllers;

import com.messager.service.com.messager.service.model.Comment;
import com.messager.service.com.messager.service.model.Message;
import com.messager.service.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(CommentController.BASE_URL)
public class CommentController {

    public static final String BASE_URL = "api/v1/messages";


    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{messageId}/comments")
    public Set<Comment> getAllComments(@PathVariable Long messageId){
        return commentService.findAllComments(messageId);
    }

    @GetMapping("/{messageId}/comments/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentService.findCommentById(id);
    }

    @PostMapping("/{messageId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment saveComment(@RequestBody Comment comment, @PathVariable Long messageId){
        comment.setMessage(new Message(messageId, "", ""));
        return commentService.saveComment(comment);
    }

}
