package com.sunyjams.domain.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunyjams.common.utils.ScaleViewUtils;
import com.sunyjams.domain.R;

/**
 * Created by James
 * on 2017/10/24.
 * description
 */
public class HeadFlatButton extends LinearLayout {

    private ImageView mImageView, ribbonImageView;
    private TextView mTextView;

    private boolean isShowMasterIcon = false;
    private String nickname = "";

    public HeadFlatButton(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        initViews(ctx);
    }

    public HeadFlatButton(Context ctx) {
        super(ctx);
        initViews(ctx);
    }

    private void initViews(Context ctx) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.view_head_flat, this, true);

        ScaleViewUtils.init(getContext());
        ScaleViewUtils.scaleView(root);

        mImageView = (ImageView) root.findViewById(R.id.iv_icon);
        mTextView = (TextView) root.findViewById(R.id.tv_nickname);
        ribbonImageView = (ImageView) root.findViewById(R.id.ribbons);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnFocusChangeListener(mOnFocusChangeListener);
    }

    public void setNickName(String nickName) {
        this.nickname = nickName;
        mTextView.setText(TextUtils.isEmpty(nickName) ? "" : nickName.trim());
        mTextView.setSelected(true);
        mTextView.setMarqueeRepeatLimit(1);
    }

    public void setHeadIcon(String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(getContext().getApplicationContext()).load(url).into(mImageView);
        }
    }

    public void setShowMasterIcon(boolean isShow) {
        this.isShowMasterIcon = isShow;
        showMasterIcon();
    }

    private void showMasterIcon() {
        if (isShowMasterIcon) {
            ribbonImageView.setVisibility(VISIBLE);
        } else {
            ribbonImageView.setVisibility(GONE);
        }
    }


    public void setHeadIndex(int index) {
        setBackgroundByIndex(index);
    }

    private void setBackgroundByIndex(int index) {
        int res = R.color.colorBlue;
        switch (index) {
            case 0:
                res = R.color.colorBlue;
                break;
            case 1:
                res = R.color.colorGreen;
                break;
            case 2:
                res = R.color.colorPink;
                break;
            case 3:
                res = R.color.colorPurple;
                break;
            case 4:
                res = R.color.colorOrange;
                break;
            case 5:
                res = R.color.colorBrown;
                break;
        }
        setBackgroundResource(res);
    }

    private OnFocusChangeListener mOnFocusChangeListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                setHasFocus(v);
            } else {
                v.setScaleY(1.0f);
                v.setScaleX(1.0f);
                mTextView.setEllipsize(TextUtils.TruncateAt.END);
                mTextView.setTextColor(Color.WHITE);
            }
        }
    };

    private void setHasFocus(View view) {
        mTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        view.setScaleX(1.3f);
        view.setScaleY(1.3f);
        mTextView.setTextColor(Color.BLACK);
        View parentView = (View) getParent();
        bringToFront();
        parentView.requestLayout();
        parentView.invalidate();
    }


}
