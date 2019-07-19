package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //prepared statements
    private static final String INSERT_POST_SQL =
            "INSERT INTO post (post_date ,poster_name ,post) values (?,?,?)";
    private static final String SELECT_POST_SQL =
            "SELECT * FROM post WHERE post_id=?";
    private static final String SELECT_ALL_POST_SQL =
            "SELECT * FROM post";
    private static final String UPDATE_POST_SQL =
            "UPDATE post SET post_date=?,poster_name=?,post=? WHERE post_id=?";
    private static final String DELETE_POST_SQL =
            "DELETE FROM post WHERE post_id=?";
    private static final String SELECT_POST_BY_POSTER_NAME_SQL =
            "SELECT * FROM post WHERE poster_name =?";

    /**
     * adds post
     * @param post
     * @return Post
     */
    @Override
    @Transactional
    public Post createPost(Post post) {
        jdbcTemplate.update(
                INSERT_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost()
        );
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        post.setPostID(id);
        return post;
    }

    /**
     * To get a post
     * @param postId
     * @return
     */
    @Override
    public Post getPost(int postId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST_SQL, this::mapRowToPost, postId);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this post id, return null
            return null;
        }
    }

    /**
     * To update a post
     * @param post
     */
    @Override
    public void updatePost(Post post) {
        jdbcTemplate.update(
                UPDATE_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostID()
        );
    }

    /**
     * To delete a post
     * @param postId
     */
    @Override
    public void deletePost(int postId) {
        jdbcTemplate.update(DELETE_POST_SQL, postId);
    }

    /**
     * To get all post
     * @return
     */
    @Override
    public List<Post> getAllPost(){
        return jdbcTemplate.query(SELECT_ALL_POST_SQL, this::mapRowToPost);
    }

    @Override
    public List<Post> getPostsByPosterName(String posterName){
         return jdbcTemplate.query(SELECT_POST_BY_POSTER_NAME_SQL, this::mapRowToPost,posterName);
    }

    /**
     * Maps row from database to Post object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostID(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));
        return post;
    }
}
