package com.quanyan.permission.mapper;

import com.quanyan.permission.entity.GroupManager;
import com.quanyan.permission.entity.GroupManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupManagerMapper {
    int countByExample(GroupManagerExample example);

    int deleteByExample(GroupManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupManager record);

    int insertSelective(GroupManager record);

    List<GroupManager> selectByExample(GroupManagerExample example);

    GroupManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupManager record, @Param("example") GroupManagerExample example);

    int updateByExample(@Param("record") GroupManager record, @Param("example") GroupManagerExample example);

    int updateByPrimaryKeySelective(GroupManager record);

    int updateByPrimaryKey(GroupManager record);
}