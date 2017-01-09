package com.medmeeting.banner.web;

import com.medmeeting.banner.dao.BannerMapper;
import com.medmeeting.banner.entity.Banner;
import com.medmeeting.base.entity.ResultDate;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luosonglin on 01/12/2016.
 */
@RestController
@RequestMapping(value = "/${com.medmeeting.project.type}/${com.medmeeting.project.version}/banner")
public class BannerController {

    @Autowired
    private BannerMapper bannerMapper;

    @ApiOperation(value="所有banner", notes="活动banner")
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResultDate getBannerList() {
        ResultDate resultDate = new ResultDate();

        resultDate.setCode(200);
        resultDate.setData(bannerMapper.getAllBanner());

        return resultDate;
    }

    @ApiOperation(value="正在展示的banner", notes="活动banner")
    @RequestMapping(value="/doing", method= RequestMethod.GET)
    public ResultDate getDoingBannerList() {
        ResultDate resultDate = new ResultDate();

        resultDate.setCode(200);
        resultDate.setData(bannerMapper.getAllDoingBanner());

        return resultDate;
    }

    @ApiOperation(value="过期banner", notes="活动banner")
    @RequestMapping(value="/done", method= RequestMethod.GET)
    public ResultDate getDoneBannerList() {
        ResultDate resultDate = new ResultDate();

        resultDate.setCode(200);
        resultDate.setData(bannerMapper.getAllDoneBanner());

        return resultDate;
    }

    @ApiOperation(value="创建活动banner", notes="根据Banner对象创建Banner")
    @ApiImplicitParam(name = "banner", value = "详细实体Banner", required = true, dataType = "Banner")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ResultDate postUser(@ModelAttribute Banner banner) {
        ResultDate resultDate = new ResultDate();

        bannerMapper.insert(banner.getUrl(), banner.getTitle(), banner.getContent());
        resultDate.setCode(200);
        resultDate.setData("success");

        return resultDate;
    }

    @ApiOperation(value="下线", notes="")
    @ApiImplicitParam(name = "id", value = "banner ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public ResultDate putUser(@PathVariable Integer id) {

        Banner u = bannerMapper.getBannerById(id);
        u.setIsDisplay(1);
        bannerMapper.updateBanner(u);

        ResultDate resultDate = new ResultDate();
        Map<Object, Object> responseMap = new HashMap<>();

        resultDate.setCode(200);
        responseMap.put("mag", "success");
        responseMap.put("banner", u.getIsDisplay());
        resultDate.setData(responseMap);

        return resultDate;
    }
}
