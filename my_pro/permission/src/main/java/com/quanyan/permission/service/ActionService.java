package com.quanyan.permission.service;

import com.quanyan.permission.entity.Action;

/**
 * Created by youxiaojia on 2016/8/12.
 * 动作service
 */
public interface ActionService {
    /**
     * 添加动作
     * @param action
     * @return
     */
    int addAction(Action action);

    /**
     * 删除动作
     * @param actionId
     * @return
     */
    int delAction(Integer actionId);
}
