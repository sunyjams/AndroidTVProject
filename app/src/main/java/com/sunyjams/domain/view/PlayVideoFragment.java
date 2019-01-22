package com.sunyjams.domain.view;

import android.os.Bundle;
import android.support.v17.leanback.app.VideoSupportFragment;
import android.support.v17.leanback.app.VideoSupportFragmentGlueHost;
import android.support.v17.leanback.media.MediaPlayerGlue;
import android.support.v17.leanback.media.PlaybackGlue;

/**
 * Created by James
 * Date 2019/1/22.
 * description
 */
public class PlayVideoFragment extends VideoSupportFragment {

    private MediaPlayerGlue mMediaPlayerGlue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VideoSupportFragmentGlueHost host = new VideoSupportFragmentGlueHost(this);

        mMediaPlayerGlue = new MediaPlayerGlue(getActivity());
        mMediaPlayerGlue.setHost(host);
        mMediaPlayerGlue.setMode(MediaPlayerGlue.NO_REPEAT);
        mMediaPlayerGlue.addPlayerCallback(new PlaybackGlue.PlayerCallback() {
            @Override
            public void onPreparedStateChanged(PlaybackGlue glue) {
                super.onPreparedStateChanged(glue);
                mMediaPlayerGlue.play();
            }

            @Override
            public void onPlayCompleted(PlaybackGlue glue) {
                super.onPlayCompleted(glue);
                mMediaPlayerGlue.release();
                getActivity().finish();
            }
        });
        Bundle args = getArguments();
        mMediaPlayerGlue.setTitle(args.getString("title"));
        mMediaPlayerGlue.setArtist(args.getString("artist"));
        mMediaPlayerGlue.setVideoUrl(args.getString("url"));
    }

    public static PlayVideoFragment newInstance(String title, String artist, String videoUrl){
        PlayVideoFragment fragment = new PlayVideoFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("artist", artist);
        args.putString("url", videoUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMediaPlayerGlue != null) {
            mMediaPlayerGlue.pause();
        }
    }
}
