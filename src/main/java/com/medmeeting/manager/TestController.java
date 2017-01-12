package com.medmeeting.manager;

import com.medmeeting.base.entity.ExceptionMsg;
import com.medmeeting.base.entity.ResponseData;
import com.medmeeting.comm.Const;
import com.medmeeting.web.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

/**
 * Created by luosonglin on 10/01/2017.
 */
@RestController
@RequestMapping("/user")
public class TestController extends BaseController {
    @Autowired
    private ManagerMapper managerMapper;

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ApiImplicitParam(name = "user", value = "详细实体user", required = true, dataType = "User")
    public ResponseData getBannerList(@ModelAttribute User user, HttpServletResponse response) {
        try {
            User userInfo = managerMapper.getManagerPassword(user.getName());
            if (userInfo == null) {
                return new ResponseData(ExceptionMsg.LoginNameNotExists);
            } else if (!userInfo.getPassword().equals(user.getPassword())) {//getPwd(user.getPassword())
                return new ResponseData(ExceptionMsg.LoginNameOrPassWordError);
            }


            Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, cookieSign(userInfo.getId().toString()));
            cookie.setMaxAge(Const.COOKIE_TIMEOUT);
            cookie.setPath("/");
            response.addCookie(cookie);
            getSession().setAttribute(Const.LOGIN_SESSION_KEY, userInfo);

            String preUrl = "/index";

            if(null != getSession().getAttribute(Const.LAST_REFERER)){
                preUrl = String.valueOf(getSession().getAttribute(Const.LAST_REFERER));
                if(preUrl.indexOf("/collect?") < 0){
                    preUrl = "/index";
                }
            }

            return new ResponseData(ExceptionMsg.SUCCESS, preUrl);
        } catch (Exception e) {
            return new ResponseData(ExceptionMsg.FAILED);
        }


    }
}
