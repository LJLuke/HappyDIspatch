package com.example.lijiang.happydispatch.ui.diyView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lijiang.happydispatch.R;

/**
 * Created by lijiang on 2018/2/23.
 */

public class LineItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mDividePaint;

    public LineItemDecoration(){
        mDividePaint = new Paint();
        mDividePaint.setColor(Color.parseColor("#878787"));
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = 2;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + 2;
            c.drawRect(left, top, right, bottom, mDividePaint);
        }
    }
}
