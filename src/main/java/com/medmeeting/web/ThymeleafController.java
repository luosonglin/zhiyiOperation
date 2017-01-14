package com.medmeeting.web;

import com.medmeeting.comm.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

/**
 * Created by luosonglin on 09/01/2017.
 */
@Controller
@RequestMapping("/")
public class ThymeleafController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value="/",method=RequestMethod.GET)
//    @LoggerManage(description="首页")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/index",method=RequestMethod.GET)
//    @LoggerManage(description="登陆后首页")
    public String home(Model model) {
//        long size= collectRepository.countByUserIdAndIsDelete(getUserId(),IsDelete.NO);
//        Config config = configRepository.findByUserId(getUserId());
//        Favorites favorites = favoritesRepository.findOne(Long.parseLong(config.getDefaultFavorties()));
//        List<String> followList = followRepository.findByUserId(getUserId());
//        model.addAttribute("config",config);
//        model.addAttribute("favorites",favorites);
//        model.addAttribute("size",size);
//        model.addAttribute("followList",followList);
        model.addAttribute("user",getUser());
//        model.addAttribute("newAtMeCount",noticeRepository.countByUserIdAndTypeAndReaded(getUserId(), "at", "unread"));
//        model.addAttribute("newCommentMeCount",noticeRepository.countByUserIdAndTypeAndReaded(getUserId(), "comment", "unread"));
//        model.addAttribute("newPraiseMeCount",noticeRepository.countPraiseByUserIdAndReaded(getUserId(), "unread"));
//        logger.info("collect size="+size+" userID="+getUserId());
        return "home";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
//    @LoggerManage(description="登陆页面")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
//    @LoggerManage(description="登出")
    public String logout(HttpServletResponse response) {
        getSession().removeAttribute(Const.LOGIN_SESSION_KEY);
        getSession().removeAttribute(Const.LAST_REFERER);
        Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "index";
    }

    @RequestMapping(value="/forgotpassword",method=RequestMethod.GET)
//    @LoggerManage(description="忘记密码页面")
    public String forgotPassword() {
        return "user/forgotpassword";
//        return "index";
    }

    @RequestMapping(value="/uploadHeadPortrait")
    public String uploadHeadPortrait(){
        return "user/uploadheadportrait";
    }

    @RequestMapping(value="/tool")
//    @LoggerManage(description="工具页面")
    public String tool(Model model) {
        String path="javascript:(function()%7Bvar%20description;var%20desString=%22%22;var%20metas=document.getElementsByTagName('meta');for(var%20x=0,y=metas.length;x%3Cy;x++)%7Bif(metas%5Bx%5D.name.toLowerCase()==%22description%22)%7Bdescription=metas%5Bx%5D;%7D%7Dif(description)%7BdesString=%22&amp;description=%22+encodeURIComponent(description.content);%7Dvar%20win=window.open(%22"
                + Const.BASE_PATH
                +"collect?from=webtool&url=%22+encodeURIComponent(document.URL)+desString+%22&title=%22+encodeURIComponent(document.title)+%22&charset=%22+document.charset,'_blank');win.focus();%7D)();";
        model.addAttribute("path",path);
        return "tool";
    }

    @RequestMapping(value="/newFavorites")
//    @LoggerManage(description="新建收藏夹页面")
    public String newFavorites(){
        return "favorites/newfavorites";
    }

    @RequestMapping(value = "/404")
    public String haha404() {
        return "404";
    }

    @RequestMapping(value="/mobile")
//    @LoggerManage(description="移动客户端页面")
    public String mobile() {
        return "mobile";
    }



}
