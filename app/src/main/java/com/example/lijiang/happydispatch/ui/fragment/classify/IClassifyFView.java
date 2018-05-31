package com.example.lijiang.happydispatch.ui.fragment.classify;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.ClassifyRight;

import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public interface IClassifyFView extends IBaseView {
    void getClassifyRightList(List<ClassifyRight> list);
}
