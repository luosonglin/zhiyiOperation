package com.medmeeting.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luosonglin on 29/12/2016.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello2")
    public String index() {
        return "Hello World";
    }
}