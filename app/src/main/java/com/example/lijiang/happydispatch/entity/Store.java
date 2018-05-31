package com.example.lijiang.happydispatch.entity;

/**
 * Created by lijiang on 2018/2/24.
 */

public class Store {

    /**
     * sId : 3
     * bNumber : 120
     * sName : 三号普
     * phone : 23
     * introduce : 太远了
     * address : 江北
     * distance1 : 336
     * distance2 : 235
     * distance : 343.629160578668
     */

    private int sId;
    private int bNumber;
    private String sName;
    private String phone;
    private String introduce;
    private String address;
    private int distance1;
    private int distance2;
    private double distance;

    public void setSId(int sId) {
        this.sId = sId;
    }

    public void setBNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistance1(int distance1) {
        this.distance1 = distance1;
    }

    public void setDistance2(int distance2) {
        this.distance2 = distance2;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getSId() {
        return sId;
    }

    public int getBNumber() {
        return bNumber;
    }

    public String getSName() {
        return sName;
    }

    public String getPhone() {
        return phone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getAddress() {
        return address;
    }

    public int getDistance1() {
        return distance1;
    }

    public int getDistance2() {
        return distance2;
    }

    public double getDistance() {
        return distance;
    }
}
