package com.quanyan.permission.entity;

import java.io.Serializable;

public class Action implements Serializable {
    private Integer id;

    private String actionName;

    private Integer actionColumnId;

    private String action;

    private String viewMode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getActionColumnId() {
        return actionColumnId;
    }

    public void setActionColumnId(Integer actionColumnId) {
        this.actionColumnId = actionColumnId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getViewMode() {
        return viewMode;
    }

    public void setViewMode(String viewMode) {
        this.viewMode = viewMode;
    }
}