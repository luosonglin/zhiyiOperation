package com.medmeeting.manager;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by luosonglin on 09/01/2017.
 */
@Mapper
public interface ManagerMapper {

    //姓名搜索用户
    @Select("select * from user_info where name = #{name}")
    User getManagerPassword(@Param("name") String name);

    @Update("update user_info set user_pic=#{user_pic} where id=#{id}")
    int setProfilePicture(@Param("user_pic") String profilePicture, @Param("id") Integer id);
}
