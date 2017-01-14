package com.medmeeting.web;

import com.medmeeting.base.entity.ResultDate;
import com.medmeeting.domain.UserAndBlog;
import com.medmeeting.repository.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luosonglin on 29/12/2016.
 *
 * 测试controller
 */
@RestController
public class HelloController {
    @RequestMapping("/hello2")
    public String index() {
        return "Hello World";
    }

    @Autowired
    BlogMapper blogMapper;

    @RequestMapping("/hello22")
    public ResultDate index2() {
        ResultDate resultDate = new ResultDate();

        List<UserAndBlog> blog = blogMapper.findAllBlog();
        List<String> ha = new ArrayList<>();

//        for (int i = 0; i < blog.size(); i++) {
//            ha.clear();
//
//            for (String j : blog.get(i).getImages().split(":")) {//.split(";")
//                ha.add(j);
//            }
//
//            blog.get(i).setBlogImages(ha);
//        }

        for (int i = 0; i< blog.size(); i++) {
            if (blog.get(i).getImages() == null)
                continue;
            List<String> haha = Arrays.asList(blog.get(i).getImages().split(";"));
            blog.get(i).setBlogImages(haha);
            System.out.println(haha);
        }

        resultDate.setCode(200);
        resultDate.setData(blog);
        return resultDate;
    }

}