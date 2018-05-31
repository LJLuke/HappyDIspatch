package com.example.lijiang.happydispatch.ui.diyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.entity.ClassifyLeft;
import com.example.lijiang.happydispatch.entity.ClassifyRight;
import com.example.lijiang.happydispatch.listener.ClassifyCheckListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public class TitleItemDecoration extends RecyclerView.ItemDecoration{
    private ClassifyCheckListener mCheckListener;
    private LayoutInflater mInflater;
    private int mTitleHeight;
    private List<ClassifyRight> mRightList = new ArrayList<>();
    public static String currentTitle = "";


    public void setCheckListener(ClassifyCheckListener checkListener) {
        mCheckListener = checkListener;
    }
    public static void setCurrentTitle(String title){
        TitleItemDecoration.currentTitle = title;
    }
    public TitleItemDecoration(Context context, List<ClassifyRight> rightList){
        this.mRightList = rightList;
        mInflater = LayoutInflater.from(context);
        Paint paint = new Paint();
        mTitleHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, context.getResources().getDisplayMetrics());
        int titleFontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, context.getResources().getDisplayMetrics());
        paint.setTextSize(titleFontSize);
        paint.setAntiAlias(true);
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c,final RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        GridLayoutManager manager = (GridLayoutManager) parent.getLayoutManager();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = manager.getSpanSizeLookup();
        int pos = ((LinearLayoutManager)(parent.getLayoutManager())).findFirstVisibleItemPosition();
        int spanSize = spanSizeLookup.getSpanSize(pos);
        View child = parent.findViewHolderForLayoutPosition(pos).itemView;
        boolean isTranslate = false;
        String tag = mRightList.get(pos).getTitleName();
        if (mRightList.get(pos).isTitle()){
            if (spanSize == 1){
                if (child.getHeight() + child.getTop() <= mTitleHeight){
                    c.save();
                    isTranslate = true;
                    int height = child.getHeight() + child.getTop() - mTitleHeight;
                    c.translate(0, height);
                }
            }
        }
        drawHeader(parent,pos,c);
        if (isTranslate){
            c.restore();
        }
//        if (!currentTitle.equals(tag)){
//            Log.d("tag","fdsfg");
//            currentTitle = tag;
//            //mCheckListener.check(mRightList.get(pos).getLeftPosition(),true);
//        }
    }

    private void drawHeader(RecyclerView parent,int pos,Canvas canvas){
        View titleView = mInflater.inflate(R.layout.item_classify_title,parent,false);
        TextView titleName = titleView.findViewById(R.id.tv_title);
        titleName.setText(mRightList.get(pos).getTitleName());
        int toDrawWidthSpec;//用于测量的widthMeasureSpec
        int toDrawHeightSpec;//用于测量的heightMeasureSpec
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) titleView.getLayoutParams();
        if (lp == null) {
            lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);//这里是根据复杂布局layout的width height，new一个Lp
            titleView.setLayoutParams(lp);
        }
        titleView.setLayoutParams(lp);
        if (lp.width == ViewGroup.LayoutParams.MATCH_PARENT) {
            //如果是MATCH_PARENT，则用父控件能分配的最大宽度和EXACTLY构建MeasureSpec
            toDrawWidthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth() - parent.getPaddingLeft() - parent.getPaddingRight(), View.MeasureSpec.EXACTLY);
        } else if (lp.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            //如果是WRAP_CONTENT，则用父控件能分配的最大宽度和AT_MOST构建MeasureSpec
            toDrawWidthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth() - parent.getPaddingLeft() - parent.getPaddingRight(), View.MeasureSpec.AT_MOST);
        } else {
            //否则则是具体的宽度数值，则用这个宽度和EXACTLY构建MeasureSpec
            toDrawWidthSpec = View.MeasureSpec.makeMeasureSpec(lp.width, View.MeasureSpec.EXACTLY);
        }
        //高度同理
        if (lp.height == ViewGroup.LayoutParams.MATCH_PARENT) {
            toDrawHeightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight() - parent.getPaddingTop() - parent.getPaddingBottom(), View.MeasureSpec.EXACTLY);
        } else if (lp.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            toDrawHeightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight() - parent.getPaddingTop() - parent.getPaddingBottom(), View.MeasureSpec.AT_MOST);
        } else {
            toDrawHeightSpec = View.MeasureSpec.makeMeasureSpec(mTitleHeight, View.MeasureSpec.EXACTLY);
        }
        //依次调用 measure,layout,draw方法，将复杂头部显示在屏幕上
        titleView.measure(toDrawWidthSpec, toDrawHeightSpec);
        titleView.layout(parent.getPaddingLeft(), parent.getPaddingTop(), parent.getPaddingLeft() + titleView.getMeasuredWidth(), parent.getPaddingTop() + titleView.getMeasuredHeight());
        titleView.draw(canvas);
    }
}
