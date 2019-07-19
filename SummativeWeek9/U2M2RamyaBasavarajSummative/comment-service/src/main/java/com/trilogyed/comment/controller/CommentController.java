package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.exception.NotFoundException;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/comments")
@CacheConfig(cacheNames = {"commentscache"})
public class CommentController {

    @Autowired
    CommentDao commentDao;

    public CommentController(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    /**
     * To post a new comment
     * @param comment
     * @return Comment
     */
    @CachePut(key = "#result.getCommentId()")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Comment addComment(@RequestBody Comment comment) {
      //  System.out.println("creating comment"); // To test cache
        return commentDao.addComment(comment);
    }

    /**
     * To get a new comment
     * @param commentID
     * @return Comment
     */
    @Cacheable
    @GetMapping("/{commentID}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable("commentID") int commentID) {
     //   System.out.println("get comments"); // To test cache
        Comment comment = commentDao.getComment(commentID);
        if(comment == null){
         throw new NotFoundException("Comment could not be retrieved for id " + commentID);
        }
        return comment;
    }

    /**
     * To get all comments
     * @return List<Comment>
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments() {
     //    To test cache   System.out.println("get all comments");// To test cache
        return commentDao.getAllComments();
    }

    /***
     * To get comments by post id
     * @param postId
     * @return List<Comment>
     */
    @GetMapping("/byPostID/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllCommentsByPostId(@PathVariable("postId") int postId) {
      //  System.out.println("get all comments by postId"); // To test cache
        return commentDao.getCommentByPostId(postId);
    }

    /**
     * To update a comment
     * @param comment
     * @param commentID
     */
    @CacheEvict(key = "#comment.getCommentId()")
    @PutMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@RequestBody Comment comment, @PathVariable("commentId") int commentID) {
      //  System.out.println("update comments"); // To test cache
        if (comment.getCommentId() == 0) {
            comment.setCommentId(commentID);
        }
        if (commentID != comment.getCommentId()) {
            throw new IllegalArgumentException("comment ID on path must match the ID in the Comment object");
        }
        commentDao.updateComment(comment);
    }

    /**
     * To delete a comment
     * @param commentId
     */
    @CacheEvict
    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("commentId") int commentId) {
       // System.out.println("delete comments");// To test cache
        commentDao.deleteComment(commentId);
    }
}
