package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
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
@RequestMapping("/posts")
@CacheConfig(cacheNames = {"postscache"})
public class PostController {
    @Autowired
    PostDao postDao;

    /**
     * To create a new post
     *
     * @param post
     * @return Post
     */
    @CachePut(key = "#result.getPostID()")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
      //  System.out.println("Create post"); // to test cache
        return postDao.createPost(post);
    }

    /**
     * To get a post
     *
     * @param postId
     * @return Post
     */
    @Cacheable
    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int postId) {
     //   System.out.println("get post"); // to test cache
        Post post = postDao.getPost(postId);
        if (post == null) {
            throw new NotFoundException("Post could not be retrieved for id " + postId);
        }
        return post;
    }

    /**
     * To get all posts
     * @return List<Post>
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Post>  getAllPost() {
       return postDao.getAllPost();
    }

    /**
     * Update a post
     *
     * @param post
     * @param postId
     */
    @CacheEvict(key = "#post.getPostID()")
    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody Post post, @PathVariable int postId) {
      //  System.out.println("update post"); // to test cache
        if (post.getPostID() == 0) {
            post.setPostID(postId);
        }
        if (postId != post.getPostID()) {
            throw new IllegalArgumentException("Post ID on path must match the ID in the Post object");
        }
        postDao.updatePost(post);
    }

    /**
     * To delete a post
     *
     * @param postId
     */
    @CacheEvict
    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int postId) {
      //  System.out.println("Delete post"); // to test cache
        postDao.deletePost(postId);
    }

    @GetMapping("/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPostsByPosterName(@PathVariable("posterName") String posterName){
      return  postDao.getPostsByPosterName(posterName);
    }
}
