package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.example.H1emuBoot;
import com.example.util.HttpClient;
import net.mamoe.mirai.event.events.BotOnlineEvent;

import javax.management.remote.JMXServerErrorException;
import java.io.IOException;

public class eventController {
    public static   String queryEvent(BotOnlineEvent event) throws IOException {
        if (JSONObject.parseObject(HttpClient.httpGet("http://127.0.0.1:8081/event/queryAll")).getString("data").contains("[]")==false){
            groupController.update_Groups(event);
            HttpClient.httpGet("http://127.0.0.1:8081/event/truncateEvent");
            return null;
        }else {
            return null;
        }
    }


}
