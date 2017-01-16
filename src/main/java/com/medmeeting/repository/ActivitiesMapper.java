package com.medmeeting.repository;

import com.medmeeting.domain.Activities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luosonglin on 01/12/2016.
 */
@Mapper
public interface ActivitiesMapper {
    @Select("select id, url, title, content, created_at, deleted_at from activities ")
    List<Activities> getAllActivities();

    @Select("select id, url, title, content, created_at, deleted_at from activities where is_display = 0")
    List<Activities> getDoingActivities();

    @Select("select id, url, title, content, created_at, deleted_at from activities where is_display = 1")
    List<Activities> getDoneActivities();
}
