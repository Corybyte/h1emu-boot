package com.example.util;

import com.example.H1emuBoot;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class GroupUtil  {

    /*获取群成员列表*/
   public  void    getMembers(GroupMessageEvent event){
       H1emuBoot.INSTANCE.getLogger().info(event.getGroup().getMembers().toString());
   }

   public  void getQQ_name(){

   }


}
