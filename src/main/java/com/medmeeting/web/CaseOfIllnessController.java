package com.medmeeting.web;

import com.medmeeting.base.entity.ExceptionMsg;
import com.medmeeting.base.entity.Response;
import com.medmeeting.domain.CaseOfIllness;
import com.medmeeting.domain.UserAndCase;
import com.medmeeting.repository.CaseMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
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
     * 新建病例
     * @param title
     * @return
     */
    @RequestMapping(value="/add/{title}/{chief_complain}/{chief_complain_image}/{body_check}/{body_check_image}/{medical_diagnosis}/{medical_diagnosis_image}/{follow_up}/{follow_up_image}", method= RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "title", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "chief_complain", value = "chief_complain", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "chief_complain_image", value = "chief_complain_image", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "body_check", value = "body_check", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "body_check_image", value = "body_check_image", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "medical_diagnosis", value = "medical_diagnosis", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "medical_diagnosis_image", value = "medical_diagnosis_image", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "follow_up", value = "follow_up", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "follow_up_image", value = "follow_up_image", required = true, dataType = "String", paramType = "path")
    })
//    @LoggerManage(description="新建病例")
    public Response addFavorites(@PathVariable("title") String title,
                                 @PathVariable("chief_complain") String chief_complain,
                                 @PathVariable("chief_complain_image") String chief_complain_image,
                                 @PathVariable("body_check") String body_check,
                                 @PathVariable("body_check_image") String body_check_image,
                                 @PathVariable("medical_diagnosis") String medical_diagnosis,
                                 @PathVariable("medical_diagnosis_image") String medical_diagnosis_image,
                                 @PathVariable("follow_up") String follow_up,
                                 @PathVariable("follow_up_image") String follow_up_image){
        if(StringUtils.isNotBlank(title)){
            CaseOfIllness caseOfIllness = caseMapper.getCaseOfIllness(title);
            if(null != caseOfIllness){
                logger.info("已有该病例标题");
                return result(ExceptionMsg.FavoritesNameUsed);
            }else{
                try {
                    if (getUserId() == 0) {
                        return result(ExceptionMsg.UserIdIsNull);
                    } else {
                        CaseOfIllness caseOfIllness1 = new CaseOfIllness();
                        caseOfIllness1.setTitle(title);
                        caseOfIllness1.setUserId(getUserId());
                        caseOfIllness1.setChiefComplain(chief_complain);
                        caseOfIllness1.setChiefComplainImage(chief_complain_image);
                        caseOfIllness1.setBodyCheck(body_check);
                        caseOfIllness1.setBodyCheckImage(body_check_image);
                        caseOfIllness1.setMedicalDiagnosis(medical_diagnosis);
                        caseOfIllness1.setMedicalDiagnosisImage(medical_diagnosis_image);
                        caseOfIllness1.setFollowUp(follow_up);
                        caseOfIllness1.setFollowUpImage(follow_up_image);
                        caseOfIllness1.setCreatedAt(new Date());
                        caseOfIllness1.setCommentCount(0);
                        caseOfIllness1.setLikeCount(0);
                        caseOfIllness1.setIsHot(0);

                        caseMapper.insertByCase(caseOfIllness1);
                        logger.info("haha" + getUserId());
                    }

                } catch (Exception e) {
                    logger.error("异常：",e);
                    return result(ExceptionMsg.FAILED);
                }
            }
        }else{
            logger.info("病例标题为空");
            return result(ExceptionMsg.FavoritesNameIsNull);
        }
        return result();
    }
}
