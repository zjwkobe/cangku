package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/6/30.
 */
public class SettingController {
    @RequestMapping("/setting")
    @ResponseBody
    public String setting(){
        return "kospjd";
    }
}
