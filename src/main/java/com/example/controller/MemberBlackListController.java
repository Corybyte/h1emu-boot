package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.util.JSONObject1O;
import com.example.H1emuBoot;
import com.example.util.HttpClient;
import jdk.tools.jaotc.collect.jar.JarSourceProvider;
import net.mamoe.mirai.event.events.MemberJoinRequestEvent;
import net.mamoe.mirai.event.events.MemberLeaveEvent;

import java.io.IOException;
import java.util.Map;

public class MemberBlackListController {
    public  String addMemberBlackList(MemberLeaveEvent event) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("QQID",event.getMember().getId());
        jsonObject.put("QQName",event.getMember().queryProfile().getNickname());
        jsonObject.put("exitGroupId",event.getGroupId());
        jsonObject.put("exitGroupName",event.getGroup().getName());
        jsonObject.put("exitGroupAvatar",event.getGroup().getAvatarUrl());
        jsonObject.put("QQEmail",event.getMember().queryProfile().getEmail());
        jsonObject.put("QQSign",event.getMember().queryProfile().getSign());
        jsonObject.put("QQAge",event.getMember().queryProfile().getAge());
        jsonObject.put("QQLevel",event.getMember().queryProfile().getQLevel());
        H1emuBoot.INSTANCE.getLogger().info(jsonObject.toString());
        HttpClient.httpPost("http://127.0.0.1:8081/MemberBlackList/addMemberBlackList",jsonObject.toString());
        return null;
    }

    public String  Memberjoin(MemberJoinRequestEvent event) throws IOException {

        JSONArray objects = JSON.parseArray(HttpClient.httpGet("http://127.0.0.1:8081/MemberBlackList/queryAll"));

        for(int i=0;i<objects.size();i++) {
            if(String.valueOf(event.getFromId()).contains(String.valueOf(objects.getJSONObject(i).get("qqid")))){
                event.reject(false,"您已被拉入黑名单，请联系管理员");
            }
        }
        event.accept();



        return null;
    }

}
