package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.StwitterPostViewModel;
import com.trilogyed.stwitter.util.comments.Comment;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import com.trilogyed.stwitter.util.posts.Post;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.#";

    @Autowired
    private CommentClient commentClient;

    @Autowired
    private PostClient postClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

public ServiceLayer(PostClient postClient,CommentClient commentClient,RabbitTemplate rabbitTemplate){
    this.postClient = postClient;
    this.commentClient =commentClient;
    this.rabbitTemplate = rabbitTemplate;
}
    /**
     * To add post and comments to the respective API
     *
     * @param switterPostViewModel
     * @return
     */

    public StwitterPostViewModel createPost(StwitterPostViewModel switterPostViewModel) {
        //add post to Post API by calling client
       Post post = new Post(
               switterPostViewModel.getPostDate(),
               switterPostViewModel.getPosterName(),
               switterPostViewModel.getPostContent());
       final Post postAdded=  postClient.createPost(post);
        //set post id to view model
        switterPostViewModel.setPostId(postAdded.getPostID());

        //to send comments in queue and comments to Comment API
        if (postAdded.getPostID() != 0 && switterPostViewModel.getComments() != null) {
            switterPostViewModel.getComments().forEach(comment -> {
                comment.setPostId(postAdded.getPostID());
                System.out.println("Sending comment...");
                rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
                System.out.println("Comment Sent");
            });

        }
        try {
            Thread.sleep(2100);
            //set comments to view model
            switterPostViewModel.setComments(commentClient.getCommentByPostId(postAdded.getPostID()));
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        return switterPostViewModel;
    }

    ;

    public List<StwitterPostViewModel> getPostByPosterName(String posterName) {
        List<StwitterPostViewModel> switterPostViewModelList = new ArrayList<>();
        StwitterPostViewModel switterPostViewModel = new StwitterPostViewModel();
        List<Post> postList = postClient.getPostByPosterName(posterName);
        if (postList != null) {
            postList.forEach(post -> {
                switterPostViewModelList.add(buildStwitterPostViewModel(post));
            });
        }
        return switterPostViewModelList;
    }


    public StwitterPostViewModel getPost(int postId) {
        List<StwitterPostViewModel> switterPostViewModelList = new ArrayList<>();
        StwitterPostViewModel switterPostViewModel = new StwitterPostViewModel();
        Post post = postClient.getPost(postId);
        if (post != null) {
            switterPostViewModel=   buildStwitterPostViewModel(post);
        }
        return switterPostViewModel;
    }

    ;

    public StwitterPostViewModel buildStwitterPostViewModel(Post post) {
        StwitterPostViewModel stwitterPostViewModel = new StwitterPostViewModel();
        stwitterPostViewModel.setPostId(post.getPostID());
        stwitterPostViewModel.setPostDate(post.getPostDate());
        stwitterPostViewModel.setPosterName(post.getPosterName());
        stwitterPostViewModel.setPostContent(post.getPost());

        List<Comment> commentList = commentClient.getCommentByPostId(post.getPostID());
        if (commentList.size() != 0) {
            stwitterPostViewModel.setComments(commentList);
        }
        return stwitterPostViewModel;
    }

}
