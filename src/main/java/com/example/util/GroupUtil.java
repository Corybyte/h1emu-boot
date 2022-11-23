package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.H1emuBoot;
import com.sun.tools.javac.util.StringUtils;
import kotlinx.serialization.json.JsonObject;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class GroupUtil  {

    /*获取群成员列表*/
   public  void    getMembers(GroupMessageEvent event) throws IOException {
       String temp[];

       //过滤非正常符号
       String json = JSON.toJSONString(
               Pattern.compile("[^0-9,$]").matcher(
                       event.getGroup().getMembers().toString()
               ).replaceAll("").trim()
       ).replace("\"", "");

       //分割字符串
       temp=json.split(",");
       MultiValueMap<String,String> stringMultiValueMap = new LinkedMultiValueMap<>();
       Map<String, String> map = new HashMap<String, String>();
       for (String obj:temp) {
           map.put(obj,event.getGroup().get(Long.parseLong(obj)).getNick());
           stringMultiValueMap.add(obj,event.getGroup().get(Long.parseLong(obj)).getNick());
           stringMultiValueMap.add(obj, String.valueOf(DateUtil.timestamp(event.getGroup().get(Long.parseLong(obj)).getJoinTimestamp())));
       }

       json=JSON.toJSONString(stringMultiValueMap.toString());
       JSONObject jsonObject =new JSONObject();
       jsonObject.put("content",map.toString());
       HttpClient.httpPost("http://nullcg.cn:8081/Group/update_Mapper",jsonObject.toString());
       event.getGroup().sendMessage(event.getGroup().getMembers().toString());
   }


}
