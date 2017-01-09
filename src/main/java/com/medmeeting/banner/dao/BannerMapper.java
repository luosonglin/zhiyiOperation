package com.medmeeting.banner.dao;

import com.medmeeting.banner.entity.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by luosonglin on 01/12/2016.
 */
@Mapper
public interface BannerMapper {

    //所有banner
    @Select("select * from banner")
    List<Banner> getAllBanner();

    //正展示的banner
    @Select("select * from banner where is_display = 0")
    List<Banner> getAllDoingBanner();

    //过期的banner
    @Select("select * from banner where is_display = 1")
    List<Banner> getAllDoneBanner();

    //创建新的banner
    @Insert("INSERT INTO banner(url, title, content) VALUES(#{url}, #{title}, #{content})")
    int insert(@Param("url") String url, @Param("title") String title, @Param("content") String content);

    //将上线的banner下线
    @Update("UPDATE banner SET is_display= #{is_display} WHERE id= #{id}")
    void updateBanner(Banner banner);

    @Select("select * from banner where id = #{id}")
    Banner getBannerById(@Param("id") Integer id);



}
