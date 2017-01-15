package com.medmeeting.web;

import com.medmeeting.domain.UserInfo;
import com.medmeeting.member.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by luosonglin on 14/01/2017.
 */
@Controller
@RequestMapping("/user2")
public class UserController {
    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping(value="/list")
//    @LoggerManage(description="登陆后首页")
    public String getUserList(Model model) {
//        long size= collectRepository.countByUserIdAndIsDelete(getUserId(),IsDelete.NO);
//        Config config = configRepository.findByUserId(getUserId());
//        Favorites favorites = favoritesRepository.findOne(Long.parseLong(config.getDefaultFavorties()));
//        List<String> followList = followRepository.findByUserId(getUserId());
//        model.addAttribute("config",config);
//        model.addAttribute("favorites",favorites);
//        model.addAttribute("size",size);
//        model.addAttribute("followList",followList);

        List<UserInfo> userInfos = userInfoMapper.getUserInfo();
        model.addAttribute("user",userInfos);

        return "user/user";
    }

    @RequestMapping(value="/list/wait")
    public String getWaitAuthenUserList(Model model) {

        List<UserInfo> userInfos = userInfoMapper.getWaitAuthenUserInfo();
        model.addAttribute("waitAuthenUser",userInfos);

        return "user/waitauthenuser";
    }

    @RequestMapping(value="/list/authen")
    public String getAuthenUserList(Model model) {

        List<UserInfo> userInfos = userInfoMapper.getAuthenUserInfo();
        model.addAttribute("authenUser",userInfos);

        return "user/authenuser";
    }

    @RequestMapping(value="/mobile")
//    @LoggerManage(description="移动客户端页面")
    public String mobile() {
        return "mobile";
    }
}
