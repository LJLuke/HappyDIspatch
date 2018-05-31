package com.example.lijiang.happydispatch.model.homePage.commodity;

import com.example.lijiang.happydispatch.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/25.
 */

public class CommentModel implements ICommentModel {
    @Override
    public List<Comment> getCommentList() {
        List<Comment> list = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            list.add(new Comment());
        }
        return list;
    }
}
