package com.medmeeting.web;

import java.util.Arrays;

/**
 * Created by luosonglin on 14/01/2017.
 *
 * 测试类
 */
public class Test {
    public static void main(String []a) {
        String ha = "http://ww3.sinaimg.cn/mw1024/a601622bgw1fa1c5g33zwj20zk0qoq9k.jpg;http://ww3.sinaimg.cn/mw1024/9dd0730bjw1f4u0rgoqooj20qo1bfjvz.jpg;http://ww4.sinaimg.cn/mw690/6fc2c0e5gw1fb6as0w2ubj20h60c8gmv.jpg";
        System.out.println(Arrays.asList(ha.split(";")));
    }
}
