package com.sunyjams.domain.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by James
 * on 2017/10/31.
 * description
 */
public class PieView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int[] colors = {Color.CYAN, Color.MAGENTA, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};

    /** 设计成可设置的 **/
    float[] nums = {80, 40, 50, 70, 20, 40, 80};

    public PieView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(150, 0, 750, 600);

        final float total = 360;
        float sum = 0;
        for (float i : nums){
            sum += i;
        }

        float start = 0;
        final int offset = 2;
        for (int i = 0; i < nums.length; i++){
            paint.setColor(getColor(i));
            float end = nums[i] * total / sum;
            if(i == nums.length - 1){
                end = total - start - offset;
            }
            canvas.drawArc(rectF, start, end, true, paint);
            paint.setColor(Color.TRANSPARENT);
            start = start + end;
            canvas.drawArc(rectF, start, offset, true, paint);
            start = start + offset;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private int getColor(int i){
        if(i == 0){
            return colors[i];
        }
        if(i % colors.length == 0){
            return colors[2];
        }
        return colors[i % colors.length];
    }
}
