package com.sunyjams.domain.model.resp;

import java.util.List;

/**
 * Created by James
 * Date 2019/1/17.
 * description
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
    private List<Actor> casts;

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
    private String directors;
}
