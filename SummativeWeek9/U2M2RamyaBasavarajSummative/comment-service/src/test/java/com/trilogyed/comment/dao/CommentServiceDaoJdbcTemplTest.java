package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentServiceDaoJdbcTemplTest {
    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception{
        List<Comment> commentList = commentDao.getAllComments();
        for(Comment comment:commentList){
            commentDao.deleteComment(comment.getCommentId());
        }
    }

    @Test
    public void getAddDeleteComment(){
        Comment actualComment= new Comment();
        actualComment.setPostId(1);
        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name");
        actualComment.setcomment("Comment");
        commentDao.addComment(actualComment);
        Comment expectedComment= commentDao.getComment(actualComment.getCommentId());
        Assert.assertEquals(expectedComment,actualComment);
        commentDao.deleteComment(actualComment.getCommentId());
        Assert.assertNull(commentDao.getComment(actualComment.getCommentId()));
    }
    @Test
    public void updateComment(){
        Comment actualComment= new Comment();
        actualComment.setPostId(1);
        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name");
        actualComment.setcomment("Comment");
        commentDao.addComment(actualComment);

        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name updated");
        actualComment.setcomment("Comment upated");
        commentDao.updateComment(actualComment);

        Comment expectedComment= commentDao.getComment(actualComment.getCommentId());

        Assert.assertEquals(expectedComment,actualComment);

    }


    @Test
    public void getCommentByPostId(){
        List<Comment> commentList = new ArrayList<>();
        Comment actualComment= new Comment();
        actualComment.setPostId(1);
        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name");
        actualComment.setcomment("Comment");
        commentDao.addComment(actualComment);


       actualComment= new Comment();
        actualComment.setPostId(1);
        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name");
        actualComment.setcomment("Comment");
        commentDao.addComment(actualComment);


        commentList = commentDao.getCommentByPostId(1);
        Assert.assertEquals(2,commentList.size());
    }

    @Test
    public void getAllComments(){
        List<Comment> commentList = new ArrayList<>();
        Comment actualComment= new Comment();
        actualComment.setPostId(1);
        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name1");
        actualComment.setcomment("Comment1");
        commentDao.addComment(actualComment);
        commentList.add(actualComment);

        actualComment= new Comment();
        actualComment.setPostId(2);
        actualComment.setCreateDate(LocalDate.of(2019,06,06));
        actualComment.setCommenterName("Commenter Name2");
        actualComment.setcomment("Comment2");
        commentDao.addComment(actualComment);
        commentList.add(actualComment);

        Assert.assertEquals(2,commentList.size());
    }

}
