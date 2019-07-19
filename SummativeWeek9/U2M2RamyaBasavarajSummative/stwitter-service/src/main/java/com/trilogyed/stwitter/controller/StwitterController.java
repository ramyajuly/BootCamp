package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.StwitterPostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import feign.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class
 */
@RestController
@RequestMapping("/posts")
@RefreshScope
public class StwitterController {

    @Autowired
    ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    /**
     * To create a new Post
     * @param switterPostViewModel
     * @return
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public StwitterPostViewModel createPost(@RequestBody @Valid StwitterPostViewModel switterPostViewModel) {
        return service.createPost(switterPostViewModel);
    }

    /**
     * To filter by poster name
     * @param posterName
     * @return
     */
    @GetMapping("/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<StwitterPostViewModel> getPostByPosterName(@PathVariable("posterName") @Valid String posterName) {
        return service.getPostByPosterName(posterName);
    }

    /**
     * To get a post
     * @param postId
     * @return
     */
    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public StwitterPostViewModel getPost(@PathVariable("postId") @Valid int postId) {
        StwitterPostViewModel stwitterPostViewModel = service.getPost(postId);
        if(stwitterPostViewModel == null){
            throw new NotFoundException("Post could not be retrieved for id " + postId);
        }
        return stwitterPostViewModel;
    }
}
