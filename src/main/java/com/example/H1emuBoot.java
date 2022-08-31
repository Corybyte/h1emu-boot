package com.example;

import net.mamoe.mirai.Mirai;
import net.mamoe.mirai.console.extension.PluginComponentStorage;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageSource;
import org.jetbrains.annotations.NotNull;

public final class H1emuBoot extends JavaPlugin {
    public static final H1emuBoot INSTANCE = new H1emuBoot();

    private H1emuBoot() {
        super(new JvmPluginDescriptionBuilder("com.example.h1emu-boot", "0.1.0")
                .name("h1emu-boot")
                .author("cg")
                .build());
    }

    @Override
    public  void onLoad(@NotNull PluginComponentStorage $this$onLoad){

    }

    @Override
    public void onEnable() {
        try {
            //监听群组消息
            Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
                String content = event.getMessage().contentToString();
                if (content.contains("习近平")) {
                    MessageSource.recall(event.getSource());
                }
                event.getSubject().sendMessage("喵");
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}