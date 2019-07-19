package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.util.comments.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "comment-service", path = "/comments")
public interface CommentClient {
    @PostMapping()
    Comment addComment(@RequestBody Comment comment);

    @GetMapping("/{commentId}")
    Comment getComment(@PathVariable("commentId") int commentId);

    @GetMapping("/byPostID/{postId}")
    List<Comment> getCommentByPostId(@PathVariable("postId") int postId);

    @GetMapping()
    List<Comment> getAllComments();
}
