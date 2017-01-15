package com.medmeeting.web;

import com.medmeeting.domain.UserAndBlog;
import com.medmeeting.domain.UserInfo;
import com.medmeeting.repository.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luosonglin on 13/01/2017.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogMapper blogMapper;

    @RequestMapping(value="/list")
//    @LoggerManage(description="所有微博")
    public String getBlogList(Model model) {

        List<UserAndBlog> blog = blogMapper.findAllBlog();
        for (UserAndBlog aBlog : blog) {
            if (aBlog.getImages() == null)
                continue;
            aBlog.setBlogImages(Arrays.asList(aBlog.getImages().split(";")));
        }

        model.addAttribute("blog",blog);

        return "blog/blog";
    }

    @RequestMapping(value="/list/recommend")
//    @LoggerManage(description="推荐微博")
    public String getRecommengBlogList(Model model) {

        List<UserAndBlog> blog = blogMapper.getRecommendBlog();
        for (UserAndBlog aBlog : blog) {
            if (aBlog.getImages() == null)
                continue;
            aBlog.setBlogImages(Arrays.asList(aBlog.getImages().split(";")));
        }

        model.addAttribute("recommendBlog",blog);

        return "blog/recommendblog";
    }

    @RequestMapping(value="/list/vip")
//    @LoggerManage(description="大咖说微博")
    public String getVipBlogList(Model model) {

        List<UserAndBlog> blog = blogMapper.getVipBlog();
        for (UserAndBlog aBlog : blog) {
            if (aBlog.getImages() == null)
                continue;
            aBlog.setBlogImages(Arrays.asList(aBlog.getImages().split(";")));
        }

        model.addAttribute("vipBlog",blog);

        return "blog/vipblog";
    }

    @RequestMapping(value="/mobile")
//    @LoggerManage(description="移动客户端页面")
    public String mobile() {
        return "mobile";
    }
}
