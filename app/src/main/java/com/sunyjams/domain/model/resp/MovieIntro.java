package com.sunyjams.domain.model.resp;



import java.util.Arrays;
import java.util.List;

/**
 * Created by James
 * Date 2019/1/20.
 * description 艺术家，包括导演和演员
 */
public class MovieIntro {

    private RateInfo rating;

    private Integer reviews_count;

    private String[] videos;

    /**
     * 多少人想看
     */
    private Integer wish_count;

    /**
     * 原名称
     */
    private String original_title;

    private String[] blooper_urls;

    private Integer collect_count;

    private Avatar images;

    private String douban_site;

    private String year;

    private List<ShortComment> popular_comments;

    private String alt;

    private String id;

    private String mobile_url;

    private Integer photos_count;

    private String pubdate;

    private String title;

    private Boolean has_video;

    private String share_url;

    private String[] languages;

    private String schedule_url;

    /**
     * 剧本
     */
    private List<Artist> writers;

    private String[] pubdates;

    private String website;

    private String[] tags;

    private Boolean has_schedule;

    private String[] durations;

    private String[] genres;

    private List<Trailer> trailers;

    private String[] trailer_urls;

    private Boolean has_ticket;

    private List<Artist> casts;

    private String[] countries;

    private String mainland_pubdate;

    private List<Stills> photos;

    private String summary;

    private String subtype;

    private List<Artist> directors;

    private Integer comments_count;

    private Integer ratings_count;

    private String[] aka;

    public RateInfo getRating() {
        return rating;
    }

    public void setRating(RateInfo rating) {
        this.rating = rating;
    }

    public Integer getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(Integer reviews_count) {
        this.reviews_count = reviews_count;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public Integer getWish_count() {
        return wish_count;
    }

    public void setWish_count(Integer wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String[] getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(String[] blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public Integer getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(Integer collect_count) {
        this.collect_count = collect_count;
    }

    public Avatar getImages() {
        return images;
    }

    public void setImages(Avatar images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<ShortComment> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<ShortComment> popular_comments) {
        this.popular_comments = popular_comments;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public Integer getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(Integer photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getHas_video() {
        return has_video;
    }

    public void setHas_video(Boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public List<Artist> getWriters() {
        return writers;
    }

    public void setWriters(List<Artist> writers) {
        this.writers = writers;
    }

    public String[] getPubdates() {
        return pubdates;
    }

    public void setPubdates(String[] pubdates) {
        this.pubdates = pubdates;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Boolean getHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(Boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public String[] getDurations() {
        return durations;
    }

    public void setDurations(String[] durations) {
        this.durations = durations;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public String[] getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(String[] trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public Boolean getHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(Boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public List<Artist> getCasts() {
        return casts;
    }

    public void setCasts(List<Artist> casts) {
        this.casts = casts;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public List<Stills> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Stills> photos) {
        this.photos = photos;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public Integer getComments_count() {
        return comments_count;
    }

    public void setComments_count(Integer comments_count) {
        this.comments_count = comments_count;
    }

    public Integer getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(Integer ratings_count) {
        this.ratings_count = ratings_count;
    }

    public String[] getAka() {
        return aka;
    }

    public void setAka(String[] aka) {
        this.aka = aka;
    }

    @Override
    public String toString() {
        return "MovieIntro{" +
                "rating=" + rating +
                ", reviews_count=" + reviews_count +
                ", videos=" + Arrays.toString(videos) +
                ", wish_count=" + wish_count +
                ", original_title='" + original_title + '\'' +
                ", blooper_urls=" + Arrays.toString(blooper_urls) +
                ", collect_count=" + collect_count +
                ", images=" + images +
                ", douban_site='" + douban_site + '\'' +
                ", year='" + year + '\'' +
                ", popular_comments=" + popular_comments +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", mobile_url='" + mobile_url + '\'' +
                ", photos_count=" + photos_count +
                ", pubdate='" + pubdate + '\'' +
                ", title='" + title + '\'' +
                ", has_video=" + has_video +
                ", share_url='" + share_url + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", schedule_url='" + schedule_url + '\'' +
                ", writers=" + writers +
                ", pubdates='" + pubdates + '\'' +
                ", website='" + website + '\'' +
                ", tags='" + tags + '\'' +
                ", has_schedule=" + has_schedule +
                ", durations=" + Arrays.toString(durations) +
                ", genres=" + Arrays.toString(genres) +
                ", trailers=" + trailers +
                ", trailer_urls=" + Arrays.toString(trailer_urls) +
                ", has_ticket=" + has_ticket +
                ", casts=" + casts +
                ", countries='" + countries + '\'' +
                ", mainland_pubdate='" + mainland_pubdate + '\'' +
                ", photos=" + photos +
                ", summary='" + summary + '\'' +
                ", subtype='" + subtype + '\'' +
                ", directors=" + directors +
                ", comments_count=" + comments_count +
                ", ratings_count=" + ratings_count +
                ", aka=" + Arrays.toString(aka) +
                '}';
    }
}
