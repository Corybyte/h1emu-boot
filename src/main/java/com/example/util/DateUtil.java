package com.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 写你的名字
 * @Date 2022/11/5 下午11:01 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
public class DateUtil {
    public static String timestamp(long time){
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000));
        return result1;
    }


}
