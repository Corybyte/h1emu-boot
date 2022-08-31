package com.example;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageSource;

import java.util.Arrays;
import java.util.List;

public final class H1emuBoot extends JavaPlugin {
    public static final H1emuBoot INSTANCE = new H1emuBoot();

    public static final String[] recallKeyword = //关键词可以存数组
            {
                    "习近平",
                    "李克强",
                    "xxx"
            };

    private H1emuBoot() {
        super(new JvmPluginDescriptionBuilder("com.example.h1emu-boot", "0.1.0")
                .name("h1emu-boot")
                .author("cg")
                .build());
    }

    //监听onLoad无意义
//    @Override
//    public  void onLoad(@NotNull PluginComponentStorage $this$onLoad){
//
//    }

    @Override
    public void onEnable() {
        try {
            //监听群组消息
            Listener<GroupMessageEvent> listener =
                    GlobalEventChannel.INSTANCE.subscribeAlways(
                            GroupMessageEvent.class,
                            this::onGroupMessage //对应下面的方法
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onGroupMessage(GroupMessageEvent event) {
        String content = event.getMessage().contentToString();
//        if (content.contains("习近平")) {
//            MessageSource.recall(event.getSource());
//        }
        for (String keyword : recallKeyword) {
            if (content.contains(keyword)) {
                MessageSource.recall(event.getSource());
                event.getGroup().sendMessage("喵"); //推荐使用getGroup()
                return;
            }
        }
    }
}