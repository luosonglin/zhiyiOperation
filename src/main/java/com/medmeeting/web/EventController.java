package com.medmeeting.web;

import com.medmeeting.domain.Event;
import com.medmeeting.repository.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by luosonglin on 09/02/2017.
 */
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventMapper eventMapper;

    @RequestMapping(value = "/allevent")
    public String getAllEventList(Model model){
        List<Event> events = eventMapper.findAllEvent();

        model.addAttribute("event", events);
        return "event/event";
    }
}
