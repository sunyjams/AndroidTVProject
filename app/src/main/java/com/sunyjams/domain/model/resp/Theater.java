package com.sunyjams.domain.model.resp;

import java.util.List;

/**
 * Created by James
 * Date 2019/1/17.
 * description 正在上映的电影信息
 */
public class Theater {

    /**
     * 打分信息
     */
    private RateInfo rating;

    /**
     * 分类标签
     */
    private String[] genres;

    /**
     * 片名
     */
    private String title;

    /**
     * 演员表
     */
    private List<Artist> casts;

    /**
     * 时长信息
     */
    private String[] durations;

    /**
     * 收藏次数
     */
    private Integer collect_count;

    /**
     * 中国大陆上映时间
     */
    private String mainland_pubdate;

    /**
     * 是否有视频
     */
    private Boolean has_video;

    /**
     * 原名称
     */
    private String original_title;

    /**
     * 固定值 movie
     */
    private String subtype;

    /**
     * 导演信息
     */
    private List<Artist> directors;

    /**
     * 发行地区及时间
     */
    private String[] pubdates;

    /**
     * 年代
     */
    private String year;

    /**
     * 海报
     */
    private Avatar images;

    /**
     * 主页
     */
    private String alt;

    /**
     * id
     */
    private String id;

    public RateInfo getRating() {
        return rating;
    }

    public void setRating(RateInfo rating) {
        this.rating = rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Artist> getCasts() {
        return casts;
    }

    public void setCasts(List<Artist> casts) {
        this.casts = casts;
    }

    public String[] getDurations() {
        return durations;
    }

    public void setDurations(String[] durations) {
        this.durations = durations;
    }

    public Integer getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(Integer collect_count) {
        this.collect_count = collect_count;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public Boolean getHas_video() {
        return has_video;
    }

    public void setHas_video(Boolean has_video) {
        this.has_video = has_video;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<Artist> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Artist> directors) {
        this.directors = directors;
    }

    public String[] getPubdates() {
        return pubdates;
    }

    public void setPubdates(String[] pubdates) {
        this.pubdates = pubdates;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Avatar getImages() {
        return images;
    }

    public void setImages(Avatar images) {
        this.images = images;
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
