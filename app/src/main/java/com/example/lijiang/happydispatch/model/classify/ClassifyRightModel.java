package com.example.lijiang.happydispatch.model.classify;

import com.example.lijiang.happydispatch.entity.ClassifyRight;
import com.example.lijiang.happydispatch.entity.Comment;
import com.example.lijiang.happydispatch.model.homePage.commodity.ICommentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ClassifyRightModel implements IClassifyRightModel{

    @Override
    public List<ClassifyRight> getClassifyRightList() {
        List<ClassifyRight> list = new ArrayList<>();
        for (int i = 0;i < 30;i++){
            for (int j = 0;j < 9;j++){
                ClassifyRight right = new ClassifyRight();
                if (j == 0){
                    right.setTitle(true);
                    right.setTitleName(i+"汽水");
                } else if (i < j){
                    right.setTag(i+"");
                    right.setTitle(false);
                    right.setTitleName(i+"汽水");
                } else {
                    right.setTitle(false);
                    right.setTitleName(i+"汽水");
                }
                list.add(right);
            }
        }
        return list;
    }
}
