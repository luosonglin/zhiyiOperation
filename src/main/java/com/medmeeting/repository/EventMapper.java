package com.medmeeting.repository;

import com.medmeeting.domain.Event;
import com.medmeeting.domain.UserAndBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luosonglin on 09/02/2017.
 */
@Mapper
public interface EventMapper {
    @Select("SELECT * FROM event, user_info where event.user_id = user_info.id")
    List<Event> findAllEvent();
}
