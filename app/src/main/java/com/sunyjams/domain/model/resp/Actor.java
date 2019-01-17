package com.sunyjams.domain.model.resp;

import java.util.List;

/**
 * Created by James
 * Date 2019/1/17.
 * description
 */

public class Actor {

    private List<Avatar> avatars;

    /**
     * 英文名
     */
    private String name_en;

    /**
     * 中文名
     */
    private String name;

    /**
     * 演员主页
     */
    private String alt;

    /**
     * 演员Id
     */
    private String id;

    public List<Avatar> getAvatars() {
        return avatars;
    }

    public void setAvatars(List<Avatar> avatars) {
        this.avatars = avatars;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
