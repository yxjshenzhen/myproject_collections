package com.quanyan.permission.entity;

import java.io.Serializable;

/**
 * Created by youxiaojia on 2016/8/12.
 */
public class ActionColumn implements Serializable{
    private static final long serialVersionUID = 7950380914421011592L;

    private Integer id;
    private String actionColumnName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionColumnName() {
        return actionColumnName;
    }

    public void setActionColumnName(String actionColumnName) {
        this.actionColumnName = actionColumnName;
    }
}
