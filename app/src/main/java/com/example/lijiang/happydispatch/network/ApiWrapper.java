package com.example.lijiang.happydispatch.network;

/**
 * Created by lijiang on 2018/3/12.
 */

public class ApiWrapper<T>{
    public int status;
    public String message;
    public T o;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return o;
    }

    public void setData(T o) {
        this.o = o;
    }
}
