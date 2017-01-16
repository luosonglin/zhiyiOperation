package com.medmeeting.member.web;

import com.medmeeting.base.entity.ResultDate;
import com.medmeeting.exception.CustomizedException;
import com.medmeeting.repository.UserInfoMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luosonglin on 25/11/2016.
 */
@RestController
@RequestMapping(value = "/${com.medmeeting.project.type}/${com.medmeeting.project.version}/userinfos")
// 通过这里配置使下面的映射都在/users下，可去除
public class UserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @ApiOperation(value="获取普通用户列表", notes="")
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResultDate getUserList() {
        ResultDate resultDate = new ResultDate();
        Map<String, Object> responseMap = new HashMap<>();

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getUserInfo());

        return resultDate;
    }

    @ApiOperation(value="获取待认证用户列表", notes="")
    @RequestMapping(value="/certificating", method= RequestMethod.GET)
    public ResultDate getWaitAuthenUserList() {
        ResultDate resultDate = new ResultDate();

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getWaitAuthenUserInfo());

        return resultDate;
    }

    @ApiOperation(value="获取认证用户列表", notes="")
    @RequestMapping(value="/cerificated", method= RequestMethod.GET)
    public ResultDate getAuthenUserList() {
        ResultDate resultDate = new ResultDate();

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getAuthenUserInfo());

        return resultDate;
    }

    @ApiOperation(value="获取普通用户数量", notes="")
    @RequestMapping(value="/count", method= RequestMethod.GET)
    public ResultDate getUserCount() {
        ResultDate resultDate = new ResultDate();
        Map<String, Object> responseMap = new HashMap<>();

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getUserCount());

        return resultDate;
    }

    @ApiOperation(value="获取待认证用户数量", notes="")
    @RequestMapping(value="/certificating/count", method= RequestMethod.GET)
    public ResultDate getWaitAuthenUserCount() {
        ResultDate resultDate = new ResultDate();
        Map<String, Object> responseMap = new HashMap<>();

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getWaitAuthenUserCount());

        return resultDate;
    }

    @ApiOperation(value="获取认证用户数量", notes="")
    @RequestMapping(value="/certificated/count", method= RequestMethod.GET)
    public ResultDate getAuthenUserCount() {
        ResultDate resultDate = new ResultDate();
        Map<String, Object> responseMap = new HashMap<>();

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getAuthenUserCount());

        return resultDate;
    }

    @ApiOperation(value="姓名搜索用户", notes="根据url的name来获取用户详细信息")
    @ApiImplicitParam(name = "name", value = "用户name", required = true, dataType = "String", paramType = "path")//如不添加paramType="path"，所有的参数类型都会是body，获取不到请求参数。参考swagger的api
    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public ResultDate getUser(@PathVariable String name) throws CustomizedException {
        ResultDate resultDate = new ResultDate();

        if (name.isEmpty()) throw new CustomizedException("名字不能为空");

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getUserInfoByName(name));
        return resultDate;
    }

    @ApiOperation(value="手机号搜索用户", notes="根据url的phone来获取用户详细信息")
    @ApiImplicitParam(name = "phone", value = "用户phone", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value="/{phone}", method=RequestMethod.GET)
    public ResultDate getUserInfo(@PathVariable String phone) throws CustomizedException {
        ResultDate resultDate = new ResultDate();

        if (phone.isEmpty()) throw new CustomizedException("名字不能为空");

        resultDate.setCode(200);
        resultDate.setData(userInfoMapper.getUserInfoByPhone(phone));
        return resultDate;
    }


    @ApiOperation(value="认证医师", notes="")
    @ApiImplicitParam(name = "user_id", value = "用户user_id", required = true, dataType = "int", paramType="path")
    @RequestMapping(value="/{user_id}", method=RequestMethod.PUT)
    public ResultDate authoruzationUser(@PathVariable Integer user_id) {

        userInfoMapper.authorization(user_id);

        ResultDate resultDate = new ResultDate();
        Map<Object, Object> responseMap = new HashMap<>();

        resultDate.setCode(200);
        responseMap.put("mag", "success");
        responseMap.put("test", user_id);
        responseMap.put("test1", userInfoMapper.getUserInfoByUserId(user_id));
        resultDate.setData(responseMap);

        return resultDate;
    }

}