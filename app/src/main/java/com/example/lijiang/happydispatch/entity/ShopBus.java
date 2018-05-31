package com.example.lijiang.happydispatch.entity;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ShopBus {

    /**
     * sName : 一号铺
     * gName : 康师傅泡面
     * gImg : /img/pm
     * gPrice : 2
     * carCount : 1
     * uId : 1
     */

    private String sName;
    private String gName;
    private String gImg;
    private int gPrice;
    private int carCount;
    private int uId;

    public void setSName(String sName) {
        this.sName = sName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public void setGImg(String gImg) {
        this.gImg = gImg;
    }

    public void setGPrice(int gPrice) {
        this.gPrice = gPrice;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public String getSName() {
        return sName;
    }

    public String getGName() {
        return gName;
    }

    public String getGImg() {
        return gImg;
    }

    public int getGPrice() {
        return gPrice;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getUId() {
        return uId;
    }
}
