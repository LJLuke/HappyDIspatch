package com.example.lijiang.happydispatch.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/1/22.
 */

public class ClassifyLeft {
    private String title;
    private Integer mImageSource;
    private Integer mCheckedImageSource;
    public Integer getCheckedImageSource() {
        return mCheckedImageSource;
    }

    public void setCheckedImageSource(Integer checkedImageSource) {
        mCheckedImageSource = checkedImageSource;
    }

    public Integer getImageSource() {
        return mImageSource;
    }

    public void setImageSource(Integer imageSource) {
        mImageSource = imageSource;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
