package com.sunyjams.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by James
 * on 2017/10/9.
 * description
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariables();
        initViews(savedInstanceState);
        loadData();
    }

    protected abstract void initVariables();
    protected abstract void initViews(Bundle saveInstanceState);
    protected abstract void loadData();

    /**
     * usage Button btn = $(R.id.button);
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T $(int id){
        return (T)super.findViewById(id);
    }
}
