package com.medmeeting.repository;

import com.medmeeting.domain.Banner;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luosonglin on 01/12/2016.
 */
@Mapper
public interface BannerMapper {

    //所有banner
    @Select("select id, url, title, content, created_at, deleted_at from banner")
    List<Banner> getAllBanner();

    //上线banner
    @Select("select id, url, title, content, created_at, deleted_at from banner where is_display = 0")
    List<Banner> getDoingBanner();

    //下线banner
    @Select("select id, url, title, content, created_at, deleted_at from banner where is_display = 1")
    List<Banner> getDoneBanner();

    //创建
//    @Insert("insert banner() values ()")

    //下线操作



}
