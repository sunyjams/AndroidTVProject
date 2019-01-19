package com.sunyjams.domain.model.resp;

import java.util.List;

/**
 * Created by James
 * Date 2019/1/17.
 * description 列表信息
 */
public class TheatersEntity {

    private Integer count;

    private Integer start;

    private Integer total;

    private List<Theater> subjects;

    private String title;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Theater> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Theater> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
