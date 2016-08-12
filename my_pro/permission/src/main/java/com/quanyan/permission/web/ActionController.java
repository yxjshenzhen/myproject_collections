package com.quanyan.permission.web;

import com.alibaba.fastjson.JSON;
import com.quanyan.permission.entity.Action;
import com.quanyan.permission.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youxiaojia on 2016/8/12.
 */
@RestController
@RequestMapping("/admin/permission")
public class ActionController {
    @Autowired
    ActionService actionService;
    /**
     * 添加动作接口
     * @param action
     * @return
     */
    @RequestMapping(value = "/addAction",method = RequestMethod.POST,produces = {"application/json; charset=UTF-8"})
    public Object addAction(@RequestBody Action action){
        actionService.addAction(action);
        return JSON.toJSON(action);
    }

}
