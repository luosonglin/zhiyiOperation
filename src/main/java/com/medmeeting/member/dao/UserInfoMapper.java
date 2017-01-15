package com.medmeeting.member.dao;

import com.medmeeting.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by luosonglin on 29/12/2016.
 */
@Mapper
public interface UserInfoMapper {

//    @Select("SELECT * FROM user_info WHERE name = #{name}")
//    User findByName(@Param("name") String name);
//
//    @Select("SELECT * FROM user_info WHERE id = #{id}")
//    User findById(@Param("id") Long id);
//
//    @Insert("INSERT INTO user_info(name, age) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);
//
//    @Insert("INSERT INTO user_info(name, age) VALUES(#{name}, #{age})")
//    int insertByUser(User manager);
//
//    @Insert("INSERT INTO user_info(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
//    int insertByMap(Map<String, Object> map);
//
//    @Update("UPDATE user_info SET age=#{age} WHERE name=#{name}")
//    void update(User manager);
//
//    @Delete("DELETE FROM user_info WHERE id =#{id}")
//    void delete(Long id);

    //所有普通用户
    @Select("select id, name, nick_name, email, mobile_phone, company, department, postion, hospital, state_date, sex, birthday, title, address, country, province, city, county, zip_code, id_code, status, phone, user_pic, authen_status, medical from user_info order by id asc")
    List<UserInfo> getUserInfo();

    //注册用户数量
    @Select("select count(*) from user_info")
    Integer getUserCount();

    //待认证用户
    @Select("select id, name, nick_name, mobile_phone, company, department, postion, hospital, state_date, sex, birthday, title, address, country, province, city, county, zip_code, id_code, status, phone, user_pic, medical from user_info where authen_status = 'X' order by id asc")
    List<UserInfo> getWaitAuthenUserInfo();

    //待认证用户数量
    @Select("select count(*) from user_info where authen_status = 'X'")
    Integer getWaitAuthenUserCount();

    //认证用户
    @Select("select id, name, nick_name, mobile_phone, company, department, postion, hospital, state_date, sex, birthday, title, address, country, province, city, county, zip_code, id_code, status, phone, user_pic, medical from user_info where authen_status = 'A' order by id asc")
    List<UserInfo> getAuthenUserInfo();

    //认证用户数量
    @Select("select count(*) from user_info where authen_status = 'A'")
    Integer getAuthenUserCount();

    //姓名搜索用户
    @Select("select name, nick_name, mobile_phone, company, department, postion, hospital, sex, birthday, title, address, country, province, city, county, zip_code, id_code, status, phone, user_pic, authen_status, medical from user_info where name = #{name}")
    UserInfo getUserInfoByName(@Param("name") String name);

    //手机搜索用户
    @Select("select  name, nick_name, mobile_phone, company, department, postion, hospital, sex, birthday, title, address, country, province, city, county, zip_code, id_code, status, phone, user_pic, authen_status, medical from user_info where mobile_phone = #{mobile_phone}")
    UserInfo getUserInfoByPhone(@Param("mobile_phone") String mobile_phone);



    @Select("select * from user_info where id = #{id}")
    UserInfo getUserInfoByUserId(@Param("id") Integer id);

    @Select("select name from user_info where id = #{user_id}")
    String getUserInfoName(@Param("user_id") Integer user_id);

    @Select("select token_id from user_info where id = #{user_id}")
    String getTokenId(@Param("user_id") Integer user_id);

    //认证用户操作
    @Update("UPDATE user_info SET authen_status='A' WHERE id =#{user_id}")
    void authorization(@Param("user_id") Integer user_id);

    @Update("UPDATE user_info SET name=#{name}, company=#{company}, postion=#{position},title=#{title}, authen_status=#{authen_status} WHERE id =#{id}")
    void update(UserInfo userInfo);

    @Update("UPDATE user_info SET name=#{name}, company=#{company}, postion=#{position}, title=#{title}, authen_status=#{authen_status} WHERE id =#{id}")
    void authorization2(@Param("id") Integer id, @Param("name") String name, @Param("company") String company, @Param("position") String position, @Param("title") String title, @Param("authen_status") String authen_status);

    int updateUserInfo(UserInfo userInfo);

    @Select("select max(id) from user_info")
    int getMaxUserId();

}
