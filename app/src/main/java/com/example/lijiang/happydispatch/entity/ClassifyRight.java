package com.example.lijiang.happydispatch.entity;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ClassifyRight {
    private String titleName;
    private int leftPosition;
    private Boolean isTitle;
    private String mCommodityName;
    private String imageUrl;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getLeftPosition() {
        return leftPosition;
    }

    public void setLeftPosition(int leftPosition) {
        this.leftPosition = leftPosition;
    }

    public Boolean isTitle() {
        return isTitle;
    }

    public void setTitle(Boolean title) {
        isTitle = title;
    }

    public String getCommodityName() {
        return mCommodityName;
    }

    public void setCommodityName(String commodityName) {
        mCommodityName = commodityName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
