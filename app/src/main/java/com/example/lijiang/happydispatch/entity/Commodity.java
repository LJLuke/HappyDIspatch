package com.example.lijiang.happydispatch.entity;

/**
 * Created by lijiang on 2018/2/24.
 */

public class Commodity {


    /**
     * gId : 1
     * gName : 康师傅泡面
     * tag : 康师傅；泡面
     * introduce : 好吃美味的泡面
     * img : /img/pm
     * bNumber : 20
     * cNumber : 0
     * price : 5
     * discount : 0.8
     * lowPrice : 2
     * sId : 1
     */

    private int gId;
    private String gName;
    private String tag;
    private String introduce;
    private String img;
    private int bNumber;
    private int cNumber;
    private int price;
    private String discount;
    private int lowPrice;
    private int sId;

    public void setGId(int gId) {
        this.gId = gId;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setBNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public void setCNumber(int cNumber) {
        this.cNumber = cNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }

    public int getGId() {
        return gId;
    }

    public String getGName() {
        return gName;
    }

    public String getTag() {
        return tag;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getImg() {
        return img;
    }

    public int getBNumber() {
        return bNumber;
    }

    public int getCNumber() {
        return cNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public int getSId() {
        return sId;
    }
}
