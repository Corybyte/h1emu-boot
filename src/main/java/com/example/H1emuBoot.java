package com.example;

import com.example.controller.GroupUtil;
import com.example.controller.MemberController;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.BotOnlineEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.io.IOException;
import java.util.Timer;


public class H1emuBoot extends JavaPlugin {
    GroupUtil groupUtil =new GroupUtil();
    MemberController memberController =new MemberController();
    Timer timer = new Timer();



    public   static  final H1emuBoot INSTANCE = new H1emuBoot();


    public H1emuBoot() {
        super(new JvmPluginDescriptionBuilder("com.example.h1emu-boot", "0.1.0")
                .name("h1emu-boot")
                .author("cg")
                .build());
    }

    //启动配置方法
    public  void onLoad(){
    }



    public void onEnable() {
        GlobalEventChannel.INSTANCE.subscribeAlways(BotOnlineEvent.class, event -> {
            //groupUtil.update_Groups(event);
            try {
                memberController.getMembers(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



    }



}