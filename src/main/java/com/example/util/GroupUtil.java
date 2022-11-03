package com.example.util;

import com.alibaba.fastjson.JSON;
import com.example.H1emuBoot;
import kotlinx.serialization.json.JsonObject;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.io.IOException;

public class GroupUtil  {

    /*获取群成员列表*/
   public  void    getMembers(GroupMessageEvent event) throws IOException {
       event.getGroup().sendMessage(event.getGroup().getMembers().toString());
       String json = JSON.toJSONString(event.getGroup().getMembers().toString());
       HttpClient.httpPost("http://nullcg.cn:8081/Group/update_Mapper",json);
   }



}
