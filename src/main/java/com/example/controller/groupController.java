package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.H1emuBoot;
import com.example.util.HttpClient;
import com.example.util.filter_string;
import net.mamoe.mirai.event.events.BotOnlineEvent;

import java.io.IOException;

public class groupController {

    /**
     *  更新群列表
     * **/
   public static void update_Groups(BotOnlineEvent event) throws IOException {
       JSONObject jsonObject =new JSONObject();
       String group[] =filter_string.filter(String.valueOf(event.getBot().getGroups())).split(",");
       for (String obj:group) {
           jsonObject.put("QQGroupID",obj);
           jsonObject.put("QQGroupName",event.getBot().getGroup(Long.parseLong(obj)).getName());
           jsonObject.put("QQGroupSize",event.getBot().getGroup(Long.parseLong(obj)).getMembers().size());
           jsonObject.put("QQGroupAvatarurl",event.getBot().getGroup(Long.parseLong(obj)).getAvatarUrl());
           H1emuBoot.INSTANCE.getLogger().info(jsonObject.toString());
           HttpClient.httpPost("http://127.0.0.1:8081/group/updateGroup",jsonObject.toString());
       }
   }


}
