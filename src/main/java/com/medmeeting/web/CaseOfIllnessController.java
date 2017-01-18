package com.medmeeting.web;

import com.medmeeting.domain.UserAndCase;
import com.medmeeting.repository.CaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by luosonglin on 18/01/2017.
 */
@Controller
@RequestMapping("/case")
public class CaseOfIllnessController {

    @Autowired
    CaseMapper caseMapper;

    @RequestMapping(value="/list")
//    @LoggerManage(description="所有病例")
    public String getBlogList(Model model) {

        List<UserAndCase> cases = caseMapper.findAllCase();
        for (UserAndCase aCase : cases) {
            if (aCase.getBodyCheckImage() == null)
                continue;
            aCase.setBodyCheckImages(Arrays.asList(aCase.getBodyCheckImage().split(";")));
        }

        model.addAttribute("case",cases);

        return "caseOfIllness/caseOfIllness";
    }
}
