package com.example.lijiang.happydispatch.model.homePage.search;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lijiang.happydispatch.database.RecordSqlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/18.
 */

public class SearchModel implements ISearchModel {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private RecordSqlHelper mSqlHelper;

    public SearchModel(Context context){
        this.mContext = context;
        mSqlHelper = new RecordSqlHelper(mContext,"record.db",null,1);
    }
    @Override
    public List<String> getGuessLike() {
        List<String> list = new ArrayList<>();
        return list;
    }

    @Override
    public List<String> getHistoricRecord() {
        List<String> list = new ArrayList<>();
        Cursor cursor = mSqlHelper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + "" + "%' order by id desc ", null);
        while (cursor.moveToNext()){
            list.add(cursor.getString(cursor.getColumnIndex("name")));
        }
        return list;
    }

    @Override
    public void saveRecord(String name) {
        mDatabase = mSqlHelper.getWritableDatabase();
        mDatabase.execSQL("insert into records(name) values('" + name + "')");
        mDatabase.close();
    }

    @Override
    public void deleteRecord() {
        mDatabase = mSqlHelper.getWritableDatabase();
        mDatabase.execSQL("delete from records");
        mDatabase.close();
    }
}
