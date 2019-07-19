package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {
    Comment addComment(Comment comment);
    Comment getComment(int commentId);
    void deleteComment(int commentId);
    void updateComment(Comment comment);
    List<Comment> getAllComments();
    List<Comment> getCommentByPostId(int postId);
}
