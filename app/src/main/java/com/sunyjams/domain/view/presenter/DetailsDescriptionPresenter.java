package com.sunyjams.domain.view.presenter;

import android.graphics.Movie;
import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.sunyjams.domain.model.resp.MovieIntro;

/**
 * Created by James
 * Date 2019/1/21.
 * description
 */
public class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder vh, Object item) {
        MovieIntro movie = (MovieIntro) item;
        if (movie != null) {
            vh.getTitle().setText(movie.getTitle());
            vh.getSubtitle().setText(movie.getOriginal_title());
            vh.getBody().setText(movie.getSummary());
        }
    }
}
