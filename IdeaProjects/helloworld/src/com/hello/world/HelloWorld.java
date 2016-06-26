package com.hello.world;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/24.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        Date date = new Date();
        System.out.println(date);
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=dt.format(date);
        System.out.println(str);

    }
}
