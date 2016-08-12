package com.qc.you.module1.entity;

import java.io.Serializable;

/**
 * Created by youxiaojia on 2016/7/21.
 */
public class ReqModel implements Serializable{
    private static final long serialVersionUID = 8581738289987354471L;
    private String req1;
    private String req2;

    public String getReq1() {
        return req1;
    }

    public void setReq1(String req1) {
        this.req1 = req1;
    }

    public String getReq2() {
        return req2;
    }

    public void setReq2(String req2) {
        this.req2 = req2;
    }
}
