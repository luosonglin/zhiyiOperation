package com.medmeeting.web;

import com.medmeeting.base.entity.Response;
import com.medmeeting.domain.Event;
import com.medmeeting.repository.EventMapper;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by luosonglin on 09/02/2017.
 */
@Controller
@RequestMapping("/event")
public class EventController extends BaseController {

    @Autowired
    private EventMapper eventMapper;

    @RequestMapping(value = "/allevent")
    public String getAllEventList(Model model){
        List<Event> events = eventMapper.getAllEventList();

        model.addAttribute("event", events);
        return "event/event";
    }

    @RequestMapping(value = "/hotevent")
    public String getHotEventList(Model model){
        List<Event> events = eventMapper.getHotEventList();

        model.addAttribute("event", events);
        return "event/event";
    }

    @RequestMapping(value = "/latestevent")
    public String getLatestEventList(Model model){
        List<Event> events = eventMapper.getLatestEventList();

        model.addAttribute("event", events);
        return "event/event";
    }

    @RequestMapping(value = "/recommendevent")
    public String getRecommendEventList(Model model){
        List<Event> events = eventMapper.getRecommendEventList();

        model.addAttribute("event", events);
        return "event/event";
    }

    @RequestMapping(value = "/{eventId}")
    public String getEventInfo(Model model, @PathVariable Integer eventId){

        Event event = eventMapper.getEventInfo(eventId);
        model.addAttribute("event", event);

        return "event/eventdetail";
    }

    /**
     * 审核会议
     * @param id
     * @return
     */
    @RequestMapping(value="/verify/{id}", method = RequestMethod.PUT)
    @ApiImplicitParam(name = "id", value = "用户event_id", required = true, dataType = "int", paramType="path")
    public Response delete(@PathVariable("id") Integer id) {

        eventMapper.verify(id);

        return result();
    }
}
