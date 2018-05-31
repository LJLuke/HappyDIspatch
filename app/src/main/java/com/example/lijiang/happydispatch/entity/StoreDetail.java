package com.example.lijiang.happydispatch.entity;

import java.util.List;

/**
 * Created by lijiang on 2018/3/22.
 */

public class StoreDetail {

    /**
     * sId : 1
     * bNumber : 35
     * sName : 一号铺
     * phone : 23
     * introduce : 好吃不贵
     * address : 重邮
     * distance1 : 25
     * distance2 : 653
     * goods : [{"gId":1,"gName":"康师傅泡面","tag":"康师傅；泡面","introduce":"好吃不贵","img":"/img/pm","bNumber":35,"cNumber":0,"price":5,"discount":"0.8","lowPrice":2,"sId":1},{"gId":2,"gName":"统一泡面","tag":"统一；泡面","introduce":"好吃不贵","bNumber":35,"cNumber":0,"price":10,"discount":"0.5","lowPrice":5,"sId":1}]
     */

    private int sId;
    private int bNumber;
    private String sName;
    private String phone;
    private String introduce;
    private String address;
    private int distance1;
    private int distance2;
    private List<GoodsEntity> goods;

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

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
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

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public static class GoodsEntity {
        /**
         * gId : 1
         * gName : 康师傅泡面
         * tag : 康师傅；泡面
         * introduce : 好吃不贵
         * img : /img/pm
         * bNumber : 35
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
}
