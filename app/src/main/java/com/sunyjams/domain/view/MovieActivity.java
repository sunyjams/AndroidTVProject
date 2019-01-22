package com.sunyjams.domain.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sunyjams.domain.R;
import com.sunyjams.domain.model.req.TheaterRequest;
import com.sunyjams.domain.model.resp.MovieIntro;

/**
 * Created by James
 * Date 2019/1/21.
 * description
 */
public class MovieActivity extends Activity {

    private MovieIntro movieIntro;

    private FrameLayout mLayout;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mLayout = findViewById(R.id.details_fragment);

        String id = getIntent().getStringExtra("id");

        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        TheaterRequest.movieInfo(id, "深圳", "", new TheaterRequest.MovieListener() {
            @Override
            public void movie(MovieIntro movie) {
                movieIntro = movie;
                transaction.replace(R.id.details_fragment, MovieFragment.newInstance());
                transaction.commit();
            }
        });
    }

    public static void start(Activity activity, String id){
        Intent intent = new Intent(activity, MovieActivity.class);
        intent.putExtra("id", id);
        activity.startActivity(intent);
    }

    public MovieIntro getMovieInfo(){
        return movieIntro;
    }
}
