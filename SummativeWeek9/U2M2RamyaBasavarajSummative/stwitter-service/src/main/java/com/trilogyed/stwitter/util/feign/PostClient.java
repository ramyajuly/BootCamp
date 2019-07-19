package com.trilogyed.stwitter.util.feign;


import com.trilogyed.stwitter.model.StwitterPostViewModel;
import com.trilogyed.stwitter.util.posts.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "post-service")
public interface PostClient {
    @PostMapping("/posts")
    Post createPost(@RequestBody Post post) ;

    @GetMapping("posts/user/{posterName}")
    List<Post> getPostByPosterName(@PathVariable("posterName") String posterName);

    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId") int postId) ;

}
