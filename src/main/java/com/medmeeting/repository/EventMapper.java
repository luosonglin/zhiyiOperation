package com.medmeeting.repository;

import com.medmeeting.domain.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luosonglin on 09/02/2017.
 */
@Mapper
public interface EventMapper {
    @Select("SELECT id, title, start_date, end_date, address, status FROM event order by id DESC")
    List<Event> getAllEventList();

    /*
        hot这个字段的设计也太.......服了！
        数据库里 `hot` char(10) default NULL COMMENT '是否标为热门会议(true,false)',
     */
    @Select("SELECT id, title, start_date, end_date, address, status FROM event where hot = 'true' order by id DESC")
    List<Event> getHotEventList();

    @Select("SELECT id, title, start_date, end_date, address, status FROM event where news = 'true' order by id DESC")
    List<Event> getLatestEventList();

    @Select("SELECT id, title, start_date, end_date, address, status FROM event where groom = 'true' order by id DESC")
    List<Event> getRecommendEventList();
}
