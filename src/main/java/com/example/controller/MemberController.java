package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.H1emuBoot;
import com.example.util.DateUtil;
import com.example.util.HttpClient;
import com.example.util.filter_string;
import net.mamoe.mirai.event.events.BotOnlineEvent;

import java.io.IOException;

public class MemberController {
    public  String  getMembers(BotOnlineEvent event) throws IOException {
        String group[] = filter_string.filter(String.valueOf(event.getBot().getGroups())).split(",");
        String Member[];
        JSONObject jsonObject =new JSONObject();
        for (String obj:group) {
            Member= String.valueOf(event.getBot().getGroup(Long.parseLong(obj)).getMembers()).split(",");
            for (String result:Member) {
                jsonObject.put("QQID",filter_string.filter(result));
                jsonObject.put("QQName",String.valueOf(event.getBot().
                        getGroup(Long.valueOf(filter_string.filter(obj))).get(Long.valueOf(filter_string.filter(result))).getNick()));

                jsonObject.put("JoinTimestamp",String.valueOf(DateUtil.timestamp(event.getBot().
                        getGroup(Long.valueOf(filter_string.filter(obj))).get(Long.valueOf(filter_string.filter(result))).getJoinTimestamp())));

                jsonObject.put("lastSpeakTimestamp",String.valueOf(DateUtil.timestamp(event.getBot().
                        getGroup(Long.valueOf(filter_string.filter(obj))).get(Long.valueOf(filter_string.filter(result))).getJoinTimestamp())));

                jsonObject.put("QQGroupID",filter_string.filter(obj));
                H1emuBoot.INSTANCE.getLogger().info(jsonObject.toString());

                HttpClient.httpPost("http://127.0.0.1:8081/Member/UpdateMember",jsonObject.toString());
            }
        }
        return null;
    }
}
