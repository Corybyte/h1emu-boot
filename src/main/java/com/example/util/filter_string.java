package com.example.util;

import com.alibaba.fastjson.JSON;

import java.util.regex.Pattern;

public class filter_string {
    public static String  filter(String data){
        String json = JSON.toJSONString(
                Pattern.compile("[^0-9,$]").matcher(
                        data
                ).replaceAll("").trim()
        ).replace("\"", "");

       return json;
    }

}
