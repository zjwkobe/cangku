package com.example.controller;


import com.example.model.User;
import com.example.service.ToutiaoService;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2016/6/29.
 */
@Controller
public class IndexController {
    /*private static final Logger logger= LoggerFactory.getLogger(IndexController.class);*/
    @Autowired
    private ToutiaoService toutiaoservice;
    @RequestMapping(path={"/","/index"})
    @ResponseBody
    public String index(){
        toutiaoservice.say();
       /* logger.info("visit index");*/
        return "hello world!";
    }
    @RequestMapping(value={"/profile/{userId}/{groupId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId,
                          @RequestParam(value="type",defaultValue = "1" ) int type) {
        return String.format("{%d},{%s},{%d}", userId, groupId, type);
    }
    @RequestMapping(value={"/vm"})
    public String news(Model model){
        model.addAttribute("value", "vv111111");
        List<String> list = Arrays.asList(new String[]{"red", "blue"});
        /*HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }*/
        model.addAttribute("list", list);
        //model.addAttribute("map", map);
        model.addAttribute("user", new User("jack"));
        return "news1";

    }
    @RequestMapping({"/request"})
    @ResponseBody
    public String request(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession session ){
        StringBuilder sb=new StringBuilder();
        Enumeration<String> headernames=request.getHeaderNames();
        while(headernames.hasMoreElements()){
            String name=headernames.nextElement();
            sb.append(name+":"+request.getHeader(name)+"<br>");
        }
        return sb.toString();

    }
    @RequestMapping({"/redirect/{code}"})
    public RedirectView redirect(@PathVariable("code") int code){
        RedirectView red=new RedirectView("/",true);
        if(code==301){
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        }
        return red;
    }
}
