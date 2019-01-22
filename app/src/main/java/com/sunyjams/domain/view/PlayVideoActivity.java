package com.sunyjams.domain.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sunyjams.domain.R;

/**
 * Created by James
 * Date 2019/1/22.
 * description
 */
public class PlayVideoActivity extends FragmentActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);


        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        transaction.replace(R.id.play_layout, PlayVideoFragment.newInstance(getIntent().getStringExtra("title"),
                getIntent().getStringExtra("artist"),
                getIntent().getStringExtra("url")));
        transaction.commit();
    }

    public static void start(Activity activity, String title, String artist, String url) {
        Intent intent = new Intent(activity, PlayVideoActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("artist", artist);
        intent.putExtra("url", url);
        activity.startActivity(intent);
    }
}
