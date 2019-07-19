package com.trilogyed.commentQueueconsumer;

import com.trilogyed.commentQueueconsumer.util.feign.CommentClient;
import com.trilogyed.commentQueueconsumer.util.feign.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Messagelistner {

    private final CommentClient client;
    @Autowired
    Messagelistner(CommentClient client) {
        this.client = client;
    }

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveNote(Comment comment) {
        try {
            if(comment.getCommentId()==0){
                Comment clientComment=client.addComment(comment);
                System.out.println("Comment created: " + clientComment.getcomment());
            }
        } catch (Exception e) {
            System.out.println(comment.getcomment() + " " + comment.getPostId());
            System.out.println("Exception occurred:" + e.getMessage());
        }
    }
}
