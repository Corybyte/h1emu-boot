package com.example;

import com.example.controller.MemberBlackListController;
import com.example.controller.eventController;
import com.example.controller.groupController;
import com.example.controller.MemberController;
import com.example.util.HttpClient;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.BotOnlineEvent;
import net.mamoe.mirai.event.events.MemberJoinRequestEvent;
import net.mamoe.mirai.event.events.MemberLeaveEvent;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class H1emuBoot extends JavaPlugin {
    groupController groupUtil = new groupController();
    MemberController memberController = new MemberController();
    MemberBlackListController memberBlackListController = new MemberBlackListController();
    Timer timer = new Timer();


    public static final H1emuBoot INSTANCE = new H1emuBoot();


    public H1emuBoot() {
        super(new JvmPluginDescriptionBuilder("com.example.h1emu-boot", "0.1.0")
                .name("h1emu-boot")
                .author("cg")
                .build());
    }

    //启动配置方法
    public void onLoad() {
    }


    public void onEnable()  {

        //群员退群
        GlobalEventChannel.INSTANCE.subscribeAlways(MemberLeaveEvent.Kick.class, (MemberLeaveEvent.Kick event) ->{
            try {
                memberBlackListController.addMemberBlackList(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //群员入群
        GlobalEventChannel.INSTANCE.subscribeAlways(MemberJoinRequestEvent.class, (MemberJoinRequestEvent event) ->{
            try {
                memberBlackListController.Memberjoin(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        /**
        GlobalEventChannel.INSTANCE.subscribeAlways(BotOnlineEvent.class, (BotOnlineEvent event) ->{
            while (true){
                try {
                    eventController.queryEvent(event);
                    Thread.sleep(1000);   // 休眠3秒
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
         **/


    }
}
