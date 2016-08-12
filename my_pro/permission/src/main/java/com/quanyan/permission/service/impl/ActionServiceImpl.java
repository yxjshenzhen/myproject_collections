package com.quanyan.permission.service.impl;

import com.quanyan.permission.entity.Action;
import com.quanyan.permission.mapper.ActionMapper;
import com.quanyan.permission.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by youxiaojia on 2016/8/12.
 */
@Service("actionService")
public class ActionServiceImpl implements ActionService {
    @Autowired
    ActionMapper actionMapper;
    @Override
    public int addAction(Action action) {
        return actionMapper.insert(action);
    }

    @Override
    public int delAction(Integer actionId) {
        return actionMapper.deleteByPrimaryKey(actionId);
    }
}
