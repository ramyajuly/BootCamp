package com.trilogyed.post.dao;


import com.trilogyed.post.model.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoJdbcTemplateImplTest {
    @Autowired
    PostDao dao;

    @Before
    public void setUp(){
        List<Post> postList = dao.getAllPost();
        for(Post post:postList){
            dao.deletePost(post.getPostID());
        }
    }

    @Test
    public void getAddDeletePost(){
        //Assemble
        Post actualPost = new Post();
        actualPost.setPost("new Post to test");
        actualPost.setPosterName("new poster name");
        actualPost.setPostDate(LocalDate.of(2019,06,06));
        //Act
        dao.createPost(actualPost);
        Post expectedPost=dao.getPost(actualPost.getPostID());
        //Assert
        Assert.assertEquals(expectedPost,actualPost);

        dao.deletePost(actualPost.getPostID());
        Assert.assertNull(dao.getPost(actualPost.getPostID()));
    }

    @Test
    public void updatePost(){
        Post actualPost = new Post();
        actualPost.setPost("new Post to test");
        actualPost.setPosterName("new poster name");
        actualPost.setPostDate(LocalDate.of(2019,06,06));
        dao.createPost(actualPost);

        actualPost.setPost("update Post to test");
        actualPost.setPosterName("update poster name");
        actualPost.setPostDate(LocalDate.of(2019,9,9));
        dao.updatePost(actualPost);

        Post expectedPost=dao.getPost(actualPost.getPostID());
        Assert.assertEquals(expectedPost,actualPost);
    }

    @Test
    public void getAllPosts(){
        Post actualPost1 = new Post();
        actualPost1.setPost("new Post to test");
        actualPost1.setPosterName("new poster name");
        actualPost1.setPostDate(LocalDate.of(2019,06,06));
        dao.createPost(actualPost1);

        Post actualPost2 = new Post();
        actualPost2.setPost("new Post to test");
        actualPost2.setPosterName("new poster name");
        actualPost2.setPostDate(LocalDate.of(2019,06,06));
        dao.createPost(actualPost2);

        List<Post> actualPostList = dao.getAllPost();
        Assert.assertEquals(2,actualPostList.size());
    }

    @Test
    public void getPostsByPosterName(){
        Post actualPost1 = new Post();
        actualPost1.setPost("Good Evening");
        actualPost1.setPosterName("Ramya");
        actualPost1.setPostDate(LocalDate.of(2019,06,06));
        dao.createPost(actualPost1);

        Post actualPost2 = new Post();
        actualPost2.setPost("Good Evening");
        actualPost2.setPosterName("Ramya");
        actualPost2.setPostDate(LocalDate.of(2019,06,06));
        dao.createPost(actualPost2);

        List<Post> actualPostList = dao.getPostsByPosterName("Ramya");
        Assert.assertEquals(2,actualPostList.size());

    }
}
