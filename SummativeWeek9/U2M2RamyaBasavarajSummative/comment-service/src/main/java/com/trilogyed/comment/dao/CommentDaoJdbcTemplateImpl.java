package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcTemplateImpl implements CommentDao {
    //prepared statements
    private static final String INSERT_COMMENT_SQL = "INSERT INTO comment (post_id, create_date, commenter_name, comment) VALUES (?,?,?,?)";
    private static final String SELECT_COMMENT_SQL = "SELECT * FROM comment WHERE comment_id=?";
    private static final String UPDATE_COMMENT_SQL = "UPDATE comment SET post_id=?, create_date=?, commenter_name=?, comment=? WHERE comment_id=?";
    private static final String DELETE_COMMENT_SQL = "DELETE FROM comment WHERE comment_id=?";
    private static final String SELECT_COMMENT_BY_POST_ID_SQL = "SELECT * FROM comment WHERE post_id=?";
    private static final String SELECT_ALL_COMMENT_SQL = "SELECT * FROM comment";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(INSERT_COMMENT_SQL, comment.getPostId(), comment.getCreateDate(),
                comment.getCommenterName(), comment.getcomment());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(id);
        return comment;
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> commentList = jdbcTemplate.query(SELECT_ALL_COMMENT_SQL, this::mapRowToComment);
        return commentList;
    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(DELETE_COMMENT_SQL, commentId);
    }


    @Override
    public Comment getComment(int commentId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL, this::mapRowToComment, commentId);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this comment id, return null
            return null;
        }
    }

    @Override
    public void updateComment(Comment comment) {
    jdbcTemplate.update(UPDATE_COMMENT_SQL,comment.getPostId(),comment.getCreateDate(),
            comment.getCommenterName(),comment.getcomment(),comment.getCommentId());
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        List<Comment> commentList = jdbcTemplate.query(SELECT_COMMENT_BY_POST_ID_SQL,this::mapRowToComment,postId);
        return  commentList;
    }

    private Comment mapRowToComment(ResultSet rs, int row) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setcomment(rs.getString("comment"));
        return comment;
    }
}
