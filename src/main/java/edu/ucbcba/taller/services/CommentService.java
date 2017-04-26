package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Comment;

/**
 * Created by alvaro on 26/4/17.
 */
public interface CommentService {
    Iterable<Comment> listAllComments();

    Comment getCommentById(Integer id);

    Comment saveComment(Comment comment);

    void deleteComment(Integer id);
}
