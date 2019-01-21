package com.sunyjams.domain.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BackgroundManager;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.sunyjams.domain.R;
import com.sunyjams.domain.model.req.TheaterRequest;
import com.sunyjams.domain.model.resp.Theater;
import com.sunyjams.domain.model.resp.TheatersEntity;
import com.sunyjams.domain.sys.log.MyLog;
import com.sunyjams.domain.view.presenter.CardPresenter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by James
 * Date 2019/1/19.
 * description
 */
public class TheaterFragment extends BrowseFragment {

    private static final String TAG = "TheaterFragment";

    private static final int BACKGROUND_UPDATE_DELAY = 300;

    private final Handler mHandler = new Handler();
    private ArrayObjectAdapter mRowsAdapter;
    private Timer mBackgroundTimer;
    private Drawable mDefaultBackground;
    private DisplayMetrics mMetrics;
    private String mBackgroundUri;
    private BackgroundManager mBackgroundManager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        prepareBackgroundManager();
        setupUIElements();
        loadTheaters();
        setupEventListeners();
    }

    private void prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(getActivity());
        mBackgroundManager.attach(getActivity().getWindow());
        mDefaultBackground = getResources().getDrawable(R.drawable.default_background);
        mMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
    }

    private void setupUIElements() {
        setTitle(getString(R.string.theater_title_default));
        // over title
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        // set search icon color
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private void loadTheaters() {
        TheaterRequest.theaterByLocation("深圳", 0, 20, "", new TheaterRequest.TheaterListener() {
            @Override
            public void theaters(TheatersEntity entity) {
                if (entity != null) {
                    setTitle(entity.getTitle());
                    if (!entity.getSubjects().isEmpty()) {
                        List<Theater> theaters = entity.getSubjects();
                        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
                        CardPresenter cardPresenter = new CardPresenter();

                        ArrayObjectAdapter theaterAdapter = new ArrayObjectAdapter(cardPresenter);
                        for (Theater theater : theaters) {
                            theaterAdapter.add(theater);
                        }
                        HeaderItem header = new HeaderItem(0, "最近热映");
                        mRowsAdapter.add(new ListRow(header, theaterAdapter));
                    }

                    HeaderItem historyHeader = new HeaderItem(1, "我看过的");

                    CardPresenter cardPresenter = new CardPresenter();
                    ArrayObjectAdapter historyAdapter = new ArrayObjectAdapter(cardPresenter);

                    mRowsAdapter.add(new ListRow(historyHeader, historyAdapter));

                    setAdapter(mRowsAdapter);
                }
            }
        });
    }

    private void setupEventListeners() {
        setOnSearchClickedListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Implement your own in-app search", Toast.LENGTH_LONG)
                        .show();
            }
        });

        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                                  RowPresenter.ViewHolder rowViewHolder, Row row) {

            if (item instanceof Theater) {
                Theater movie = (Theater) item;
                MovieActivity.start(getActivity(), movie.getId());
            }
        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof Theater) {
                mBackgroundUri = ((Theater) item).getImages().getLarge();
                startBackgroundTimer();
            }
        }
    }

    private void startBackgroundTimer() {
        if (null != mBackgroundTimer) {
            mBackgroundTimer.cancel();
        }
        MyLog.i(TAG, "startBackgroundTimer");
        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new UpdateBackgroundTask(), BACKGROUND_UPDATE_DELAY);
    }

    private class UpdateBackgroundTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    MyLog.i(TAG, "UpdateBackgroundTask");
                    updateBackground(mBackgroundUri);
                }
            });
        }
    }

    protected void updateBackground(String uri) {
        int width = mMetrics.widthPixels;
        int height = mMetrics.heightPixels;
        Glide.with(getActivity())
                .load(uri)
                .centerCrop()
                .error(mDefaultBackground)
                .bitmapTransform(new BlurTransformation(getActivity(), 14, 3))
                .into(new SimpleTarget<GlideDrawable>(width, height) {
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable>
                                                        glideAnimation) {
                        mBackgroundManager.setDrawable(resource);
                    }
                });
        mBackgroundTimer.cancel();
    }
}
