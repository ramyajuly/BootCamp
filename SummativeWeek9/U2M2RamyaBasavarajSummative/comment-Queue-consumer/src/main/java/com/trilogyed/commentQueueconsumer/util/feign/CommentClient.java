package com.trilogyed.commentQueueconsumer.util.feign;

import com.trilogyed.commentQueueconsumer.util.feign.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "comment-service", path = "/comments")
public interface CommentClient {
    @PostMapping()
    Comment addComment(@RequestBody Comment comment);
}
