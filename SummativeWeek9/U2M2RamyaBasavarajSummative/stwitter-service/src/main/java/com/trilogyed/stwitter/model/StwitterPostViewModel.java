package com.trilogyed.stwitter.model;

import com.trilogyed.stwitter.util.comments.Comment;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class StwitterPostViewModel {
    private int postId;
    @Size(max=255)
    private String postContent;
    @NotNull(message = "Please provide Post date")
    private LocalDate postDate;
    @NotEmpty(message = "Please provide poster Name")
    @Size(max=50)
    private String posterName;
    private List<Comment> comments;

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StwitterPostViewModel that = (StwitterPostViewModel) o;
        return postId == that.postId &&
                Objects.equals(postContent, that.postContent) &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postContent, postDate, posterName, comments);
    }
}
