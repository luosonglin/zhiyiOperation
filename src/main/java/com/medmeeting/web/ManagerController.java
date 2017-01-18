package com.medmeeting.web;

import com.medmeeting.base.entity.ExceptionMsg;
import com.medmeeting.base.entity.Response;
import com.medmeeting.base.entity.ResponseData;
import com.medmeeting.base.utils.DateUtils;
import com.medmeeting.base.utils.FileUtil;
import com.medmeeting.comm.Const;
import com.medmeeting.domain.CaseOfIllness;
import com.medmeeting.manager.ManagerMapper;
import com.medmeeting.manager.User;
import com.medmeeting.repository.CaseMapper;
import com.medmeeting.repository.UserInfoMapper;
import com.medmeeting.web.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;
import javax.servlet.http.Cookie;
import java.util.UUID;

/**
 * Created by luosonglin on 10/01/2017.
 * 运营管理人员
 */
@RestController
@RequestMapping("/user")
public class ManagerController extends BaseController {

    @Value("${static.url}")
    private String staticUrl;
    @Value("${file.profilepictures.url}")
    private String fileProfilepicturesUrl;


    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

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

    /**
     * 上传头像
     * @param dataUrl
     * @return
     */
    @RequestMapping(value = "/uploadHeadPortrait", method = RequestMethod.POST)
    public ResponseData uploadHeadPortrait(String dataUrl){
        logger.info("执行 上传头像 开始");
        try {
            String filePath=staticUrl+fileProfilepicturesUrl;
            String fileName= UUID.randomUUID().toString()+".png";
            String savePath = fileProfilepicturesUrl+fileName;
            String image = dataUrl;
            String header ="data:image";
            String[] imageArr=image.split(",");
            if(imageArr[0].contains(header)){
                image=imageArr[1];
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] decodedBytes = decoder.decodeBuffer(image);
                FileUtil.uploadFile(decodedBytes, filePath, fileName);
                User user = getUser();
                managerMapper.setProfilePicture(savePath, user.getId());
                user.setUserPic(savePath);
                getSession().setAttribute(Const.LOGIN_SESSION_KEY, user);
            }
            logger.info("头像地址：" + savePath);
            logger.info("执行 上传头像 结束");
            return new ResponseData(ExceptionMsg.SUCCESS, savePath);
        } catch (Exception e) {
            logger.error("upload head portrait failed, ", e);
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }

    /**
     * 认证医生
     * @param id
     * @return
     */
    @RequestMapping(value="/authen/{id}", method = RequestMethod.PUT)
    @ApiImplicitParam(name = "id", value = "用户user_id", required = true, dataType = "int", paramType="path")
    public Response delete(@PathVariable("id") Integer id) {

        userInfoMapper.authorization(id);

        return result();
    }
//    public String delete(@PathVariable("id") Integer id) {
//
//        userInfoMapper.authorization(id);
//
//        return "/user2/list/wait";
//    }


}
