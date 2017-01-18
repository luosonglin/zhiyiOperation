package com.medmeeting.web;

import com.medmeeting.base.entity.ExceptionMsg;
import com.medmeeting.base.entity.Response;
import com.medmeeting.domain.CaseOfIllness;
import com.medmeeting.domain.UserAndCase;
import com.medmeeting.repository.CaseMapper;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by luosonglin on 18/01/2017.
 */
@RestController
@RequestMapping("/case")
public class CaseOfIllnessController extends BaseController{

    @Autowired
    CaseMapper caseMapper;

 /*   @RequestMapping(value="/list")
//    @LoggerManage(description="所有病例")
    public String getBlogList(Model model) {

        List<UserAndCase> cases = caseMapper.findAllCase();
        for (UserAndCase aCase : cases) {
            if (aCase.getChiefComplainImage() == null)
                continue;
            aCase.setChiefComplainImages(Arrays.asList(aCase.getChiefComplainImage().split(";")));

            if (aCase.getBodyCheckImage() == null)
                continue;
            aCase.setBodyCheckImages(Arrays.asList(aCase.getBodyCheckImage().split(";")));

            if (aCase.getMedicalDiagnosisImage() == null)
                continue;
            aCase.setMedicalDiagnosisImages(Arrays.asList(aCase.getMedicalDiagnosisImage().split(";")));

            if (aCase.getFollowUpImage() == null)
                continue;
            aCase.setFollowUpImages(Arrays.asList(aCase.getFollowUpImage().split(";")));
        }

        model.addAttribute("case",cases);

        return "caseOfIllness/caseOfIllness";
    }


    @RequestMapping(value="/newCase")
//    @LoggerManage(description="新建病例页面")
    public String newFavorites(){
        return "caseOfIllness/newcaseofillness";
    }
*/

    /**
     * 添加
     * @param title
     * @return
     */
    @RequestMapping(value="/add/{title}",method= RequestMethod.POST)
    @ApiImplicitParam(name = "title", value = "title", required = true, dataType = "String", paramType="path")
//    @LoggerManage(description="新建病例")
    public Response addFavorites(@PathVariable("title") String title){
        if(StringUtils.isNotBlank(title)){
            CaseOfIllness caseOfIllness = caseMapper.getCaseOfIllness(title);
            if(null != caseOfIllness){
                logger.info("名称已被创建");
                return result(ExceptionMsg.FavoritesNameUsed);
            }else{
                try {
                    CaseOfIllness caseOfIllness1 = new CaseOfIllness();
                    caseOfIllness1.setTitle(title);
                    caseMapper.insertByCase(caseOfIllness1);
                    logger.info("haha");

                } catch (Exception e) {
                    logger.error("异常：",e);
                    return result(ExceptionMsg.FAILED);
                }
            }
        }else{
            logger.info("名称为空");
            return result(ExceptionMsg.FavoritesNameIsNull);
        }
        return result();
    }
}
