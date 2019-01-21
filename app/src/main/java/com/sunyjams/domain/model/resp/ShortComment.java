package com.sunyjams.domain.model.resp;

/**
 * Created by James
 * Date 2019/1/21.
 * description
 */
public class ShortComment {

    private CommentRate rating;

    private Integer useful_count;

    private UserInfo author;

    private String subject_id;

    private String content;

    private String created_at;

    private String id;

    public CommentRate getRating() {
        return rating;
    }

    public void setRating(CommentRate rating) {
        this.rating = rating;
    }

    public Integer getUseful_count() {
        return useful_count;
    }

    public void setUseful_count(Integer useful_count) {
        this.useful_count = useful_count;
    }

    public UserInfo getAuthor() {
        return author;
    }

    public void setAuthor(UserInfo author) {
        this.author = author;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
