package com.medmeeting.web;

import com.medmeeting.domain.UserAndBlog;
import com.medmeeting.repository.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
//    @LoggerManage(description="登陆后首页")
    public String getBlogList(Model model) {
//        long size= collectRepository.countByUserIdAndIsDelete(getUserId(),IsDelete.NO);
//        Config config = configRepository.findByUserId(getUserId());
//        Favorites favorites = favoritesRepository.findOne(Long.parseLong(config.getDefaultFavorties()));
//        List<String> followList = followRepository.findByUserId(getUserId());
//        model.addAttribute("config",config);
//        model.addAttribute("favorites",favorites);
//        model.addAttribute("size",size);
//        model.addAttribute("followList",followList);

        List<UserAndBlog> blog = blogMapper.findAllBlog();
        model.addAttribute("blog",blog);

        System.out.println(blog.get(0).getName());
//        System.out.print(blog.get(0).getBlogImages().get(0));

//        model.addAttribute("newAtMeCount",noticeRepository.countByUserIdAndTypeAndReaded(getUserId(), "at", "unread"));
//        model.addAttribute("newCommentMeCount",noticeRepository.countByUserIdAndTypeAndReaded(getUserId(), "comment", "unread"));
//        model.addAttribute("newPraiseMeCount",noticeRepository.countPraiseByUserIdAndReaded(getUserId(), "unread"));
//        logger.info("collect size="+size+" userID="+getUserId());
        return "blog/blog";
    }

    @RequestMapping(value="/mobile")
//    @LoggerManage(description="移动客户端页面")
    public String mobile() {
        return "mobile";
    }
}
