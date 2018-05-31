package com.example.lijiang.happydispatch.model.homePage.search;

import java.util.List;

/**
 * Created by lijiang on 2018/2/18.
 */

public interface ISearchModel {
    List<String> getGuessLike();
    List<String> getHistoricRecord();
    void saveRecord(String name);
    void deleteRecord();
}
