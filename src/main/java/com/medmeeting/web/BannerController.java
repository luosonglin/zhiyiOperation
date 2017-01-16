package com.medmeeting.web;

import com.medmeeting.domain.Banner;
import com.medmeeting.repository.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by luosonglin on 16/01/2017.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerMapper bannerMapper;

    @RequestMapping(value="/list/weibo")
    public String getWeiboBannerList(Model model) {

        List<Banner> banner = bannerMapper.getAllBanner();

        model.addAttribute("weiboBanner",banner);

        return "banner/weibobanner";
    }

    @RequestMapping(value="/list/meeting")
    public String getMeetingBannerList(Model model) {

//        List<Banner> banner = bannerMapper.getDoingBanner();
//
//        model.addAttribute("meetingBanner",banner);
//
//        return "banner/meetingbanner";

        return "404";
    }
}
