package com.example.lijiang.happydispatch.ui.activity.homePage.commodity;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Comment;

import java.util.List;

/**
 * Created by lijiang on 2018/2/25.
 */

public interface ICommentView extends IBaseView {
    void getCommentList(List<Comment> list);
}
