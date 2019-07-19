package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.StwitterPostViewModel;
import com.trilogyed.stwitter.util.comments.Comment;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;

import com.trilogyed.stwitter.util.posts.Post;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {
    @Mock
    CommentClient commentClient;
    @Mock
    PostClient postClient;
    @Mock
    RabbitTemplate rabbitTemplate;

    @InjectMocks
    ServiceLayer serviceLayer;

    @Test
    public void createPost(){
        StwitterPostViewModel actualStwitterPostViewModel = new StwitterPostViewModel();
        actualStwitterPostViewModel.setPostDate(LocalDate.of(2019,6,6));
        actualStwitterPostViewModel.setPosterName("poster name");
        actualStwitterPostViewModel.setPostContent("post");
        List<Comment> actualComments = new ArrayList<>();
        actualComments.add(new Comment(LocalDate.of(2019,6,6),
                "Commenter Name","Comment"));
        actualStwitterPostViewModel.setComments(actualComments);

        StwitterPostViewModel expectedStwitterPostViewModel = new StwitterPostViewModel();
        expectedStwitterPostViewModel.setPostId(1);
        expectedStwitterPostViewModel.setPostDate(LocalDate.of(2019,6,6));
        expectedStwitterPostViewModel.setPosterName("poster name");
        expectedStwitterPostViewModel.setPostContent("post");
        List<Comment> expectedComments = new ArrayList<>();
        expectedComments.add(new Comment(1,1,LocalDate.of(2019,6,6),
                "Commenter Name","Comment"));
        expectedStwitterPostViewModel.setComments(expectedComments);

        assertEquals(expectedStwitterPostViewModel,serviceLayer.createPost(actualStwitterPostViewModel));
    }

    @Test
    public void getPost(){
        StwitterPostViewModel expectedStwitterPostViewModel = new StwitterPostViewModel();
        expectedStwitterPostViewModel.setPostId(1);
        expectedStwitterPostViewModel.setPostDate(LocalDate.of(2019,6,6));
        expectedStwitterPostViewModel.setPosterName("poster name");
        expectedStwitterPostViewModel.setPostContent("post");
        List<Comment> expectedComments = new ArrayList<>();
        expectedComments.add(new Comment(1,1,LocalDate.of(2019,6,6),
                "Commenter Name","Comment"));
        expectedStwitterPostViewModel.setComments(expectedComments);
        assertEquals(expectedStwitterPostViewModel,serviceLayer.getPost(1));
    }

    @Test
    public void getPostByPosterName(){
        assertEquals(1,serviceLayer.getPostByPosterName("poster name").size());
    }

    @Before
    public void setUpMock(){
        serviceLayer = new ServiceLayer(postClient,commentClient,rabbitTemplate);
        Post actualPost= new Post(LocalDate.of(2019,6,6),"poster name","post");
        Post expectedPost= new Post(LocalDate.of(2019,6,6),"poster name","post");
        expectedPost.setPostID(1);

        Comment actualComment = new Comment(LocalDate.of(2019,6,6),
                "Commenter Name","Comment");
        Comment comment1 = new Comment(1,1,LocalDate.of(2019,6,6),
                "Commenter Name","Comment");
        Comment  comment2=  new Comment(2,1,LocalDate.of(2019,6,7),
                "Commenter Name1","Comment1");


        List<Post> postList = new ArrayList<>();
        postList.add(expectedPost);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);

        when(postClient.createPost(actualPost)).thenReturn(expectedPost);
        when(postClient.getPost(1)).thenReturn(expectedPost);
        when(postClient.getPostByPosterName("poster name")).thenReturn(postList);

        when(commentClient.getCommentByPostId(1)).thenReturn(commentList);
    }
}
