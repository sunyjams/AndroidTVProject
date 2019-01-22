package com.sunyjams.domain.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.app.DetailsFragmentBackgroundController;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.support.v4.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.sunyjams.domain.R;
import com.sunyjams.domain.model.resp.MovieIntro;
import com.sunyjams.domain.model.resp.Trailer;
import com.sunyjams.domain.utils.ScreenUtil;
import com.sunyjams.domain.view.presenter.DetailsDescriptionPresenter;
import com.sunyjams.domain.view.presenter.TrailerPresenter;

import java.util.List;

/**
 * Created by James
 * Date 2019/1/21.
 * description
 */
public class MovieFragment extends DetailsFragment {

    private MovieIntro movie;

    public static final String SHARED_ELEMENT_NAME = "hero";

    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int DETAIL_THUMB_HEIGHT = 274;

    private DetailsFragmentBackgroundController mBackground;
    private ClassPresenterSelector mSelector;
    private ArrayObjectAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movie = ((MovieActivity)getActivity()).getMovieInfo();

        mBackground = new DetailsFragmentBackgroundController(this);
        mSelector = new ClassPresenterSelector();
        mAdapter = new ArrayObjectAdapter(mSelector);

        setupDetailsOverviewRow();
        setupDetailsOverviewRowPresenter();
        setupRelatedMovieListRow();
        setAdapter(mAdapter);
        initializeBackground();
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    public static MovieFragment newInstance(){
        return new MovieFragment();
    }

    private void setupDetailsOverviewRow(){
        final DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow(movie);
        detailsOverviewRow.setImageDrawable(
                ContextCompat.getDrawable(getActivity(), R.drawable.default_background));
        int width = ScreenUtil.convertDpToPixel(getActivity().getApplicationContext(), DETAIL_THUMB_WIDTH);
        int height = ScreenUtil.convertDpToPixel(getActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT);

        Glide.with(getActivity())
                .load(movie.getPhotos().get(0).getImage())
                .centerCrop()
                .error(R.drawable.default_background)
                .into(new SimpleTarget<GlideDrawable>(width, height) {
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable>
                                                        glideAnimation) {
                        detailsOverviewRow.setImageDrawable(resource);
                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
                    }
                });

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        actionAdapter.add(
                new Action(
                        1,
                        "预告片"));
        actionAdapter.add(
                new Action(
                        2,
                        "短评"));
        actionAdapter.add(
                new Action(
                        3,
                        "影评"));
        detailsOverviewRow.setActionsAdapter(actionAdapter);

        mAdapter.add(detailsOverviewRow);
    }

    private void initializeBackground() {
        mBackground.enableParallax();
        Glide.with(getActivity())
                .load(movie.getPhotos().get(0).getImage())
                .asBitmap()
                .centerCrop()
                .error(R.drawable.default_background)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap,
                                                GlideAnimation<? super Bitmap> glideAnimation) {
                        mBackground.setCoverBitmap(bitmap);
                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
                    }
                });
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter =
                new FullWidthDetailsOverviewRowPresenter(new DetailsDescriptionPresenter());
        detailsPresenter.setBackgroundColor(
                ContextCompat.getColor(getActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper =
                new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(
                getActivity(), SHARED_ELEMENT_NAME);
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(new OnActionClickedListener() {
            @Override
            public void onActionClicked(Action action) {
                if (action.getId() == 1) {
                } else {

                }
            }
        });
        mSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupRelatedMovieListRow() {
        String subcategories[] = {"预告片"};
        List<Trailer> list = movie.getTrailers();

        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new TrailerPresenter());
        for (Trailer trailer : list) {
            trailer.setArtist(movie.getDirectors().get(0));
            listRowAdapter.add(trailer);
        }

        HeaderItem header = new HeaderItem(0, subcategories[0]);
        mAdapter.add(new ListRow(header, listRowAdapter));
        mSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {

        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                                  RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof Trailer) {
                PlayVideoActivity.start(getActivity(), ((Trailer) item).getTitle(), ((Trailer) item).getArtist().getName(), ((Trailer) item).getResource_url());
            }
        }
    }
}
