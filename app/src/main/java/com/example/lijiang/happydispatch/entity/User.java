package com.example.lijiang.happydispatch.entity;

/**
 * Created by lijiang on 2018/3/12.
 */

public class User {


    /**
     * status : 1
     * message : 登录成功
     * o : {"userId":1,"phone":"15340524193","password":"123","tName":"kkbit","name":"lL来","address":"cqupt"}
     */

    private int status;
    private String message;
    private OEntity o;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setO(OEntity o) {
        this.o = o;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public OEntity getO() {
        return o;
    }

    public static class OEntity {
        /**
         * userId : 1
         * phone : 15340524193
         * password : 123
         * tName : kkbit
         * name : lL来
         * address : cqupt
         */

        private int userId;
        private String phone;
        private String password;
        private String tName;
        private String name;
        private String address;

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setTName(String tName) {
            this.tName = tName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getUserId() {
            return userId;
        }

        public String getPhone() {
            return phone;
        }

        public String getPassword() {
            return password;
        }

        public String getTName() {
            return tName;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }
}
