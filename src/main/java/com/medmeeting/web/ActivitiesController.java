package com.medmeeting.web;

import com.medmeeting.domain.Activities;
import com.medmeeting.repository.ActivitiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by luosonglin on 16/01/2017.
 */
@Controller
@RequestMapping(value = "activities")
public class ActivitiesController {

    @Autowired
    ActivitiesMapper activitiesMapper;

    @RequestMapping(value="/list")
    public String getWeiboBannerList(Model model) {

        List<Activities> doingActivities = activitiesMapper.getDoingActivities();
        List<Activities> doneActivities = activitiesMapper.getDoneActivities();

        model.addAttribute("doingActivities",doingActivities);
        model.addAttribute("doneActivities", doneActivities);

        return "activities/activities";
    }


}
