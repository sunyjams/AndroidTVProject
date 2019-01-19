package com.sunyjams.domain.model.resp;

import java.util.List;

/**
 * Created by James
 * Date 2019/1/17.
 * description
 */

public class RateInfo {

    private Integer max;

    private Integer average;

    private RateDetail details;

    private String stars;

    private Integer min;

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public RateDetail getDetails() {
        return details;
    }

    public void setDetails(RateDetail details) {
        this.details = details;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }
}
