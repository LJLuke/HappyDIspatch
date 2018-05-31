package com.example.lijiang.happydispatch.model.homePage;

import com.example.lijiang.happydispatch.entity.Commodity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/26.
 */

public class TodayPreferModel implements ITodayPreferModel {
    @Override
    public List<Commodity> getTodayPreferList() {
        List<Commodity> list = new ArrayList<>();
        for (int i = 0 ;i < 10;i++){
            list.add(new Commodity());
        }
        return list;
    }
}
