package com.sunyjams.domain.model.resp;

/**
 * Created by James
 * Date 2019/1/18.
 * description 艺术家，包括导演和演员
 */
public class Artist {

    private Avatar avatars;

    /**
     * 英文名
     */
    private String name_en;

    /**
     * 名字
     */
    private String name;

    /**
     * 详细信息
     */
    private String alt;

    /**
     * id
     */
    private String id;

    public Avatar getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatar avatars) {
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
