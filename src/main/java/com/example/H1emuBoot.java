package com.example;

import com.example.util.GroupUtil;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;


public class H1emuBoot extends JavaPlugin {
    GroupUtil groupUtil =new GroupUtil();


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

        //监听群组消息
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            groupUtil.getMembers(event);
        });


    }



}