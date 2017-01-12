package com.medmeeting.manager;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by luosonglin on 09/01/2017.
 */
@Mapper
public interface ManagerMapper {

    //姓名搜索用户
    @Select("select * from user_info where name = #{name}")
    User getManagerPassword(@Param("name") String name);
}
