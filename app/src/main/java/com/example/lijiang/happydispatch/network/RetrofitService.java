package com.example.lijiang.happydispatch.network;


import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.entity.ShopBus;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.entity.StoreDetail;
import com.example.lijiang.happydispatch.entity.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by lijiang on 2018/3/8.
 */

public interface RetrofitService {
    @FormUrlEncoded
    @POST("login")
    Observable<User> login(@Field("phone") String phone, @Field("password") String password);
    @Multipart
    @POST("uploadphoto")
    Observable<ApiWrapper> updateImage(@Part MultipartBody.Part file);

    @POST("uploadphoto")
    Observable<ApiWrapper> updateImage(@Body RequestBody file);

    @FormUrlEncoded
    @POST("update")
    Observable<ApiWrapper> updateMessage(@Field("uid") int id, @Field("username") String trueName
    , @Field("tName") String nickName, @Field("phone") String phone);
    @FormUrlEncoded
    @POST("goodsdetail")
    Observable<ApiWrapper<Commodity>> getCommodityDetail(@Field("g_id") int id);
    @FormUrlEncoded
    @POST("addCar")
    Observable<ApiWrapper<Commodity>> addShopBus(@Field("uid") int uID,@Field("gid") int gID,@Field("count") int count);
    @FormUrlEncoded
    @POST("searchAll")
    Observable<ApiWrapper<List<Commodity>>> getCommodityAll(@Field("key") String key);
    @FormUrlEncoded
    @POST("searchHot")
    Observable<ApiWrapper<List<Commodity>>> getCommodityHot(@Field("key") String key);
    @FormUrlEncoded
    @POST("searchDiscount")
    Observable<ApiWrapper<List<Commodity>>> getCommodityDiscount(@Field("key") String key);
    @FormUrlEncoded
    @POST("selectgoods")
    Observable<ApiWrapper<List<Commodity>>> getCommodityFilter(@Field("tag") String tag,@Field("low") int low,@Field("high") int high);
    @FormUrlEncoded
    @POST("searchHotShop")
    Observable<ApiWrapper<List<Store>>> getStoreHot(@Field("key") String key,@Field("distance1") int distance1 ,@Field("distance2") int distance2);
    @FormUrlEncoded
    @POST("searchShopByDistance")
    Observable<ApiWrapper<List<Store>>> getStoreDistance(@Field("distance1") int distance1 ,@Field("distance2") int distance2);
    @FormUrlEncoded
    @POST("shopDetail")
    Observable<ApiWrapper<StoreDetail>> getStoreDetail(@Field("s_id") int sID);
    @FormUrlEncoded
    @POST("mycar")
    Observable<ApiWrapper<List<ShopBus>>> getShopBus(@Field("uid") int uID);
    @FormUrlEncoded
    @POST("collection")
    Observable<ApiWrapper<List<Store>>> getCollection(@Field("uid") int uID);

}
