package com.stirante.wiz3ard.MiniGame.utils;

import net.minecraft.server.v1_5_R2.NBTTagCompound;
import net.minecraft.server.v1_5_R2.NBTTagList;

import org.bukkit.craftbukkit.v1_5_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class Glow {
    
    public static ItemStack addGlow(ItemStack item){
        net.minecraft.server.v1_5_R2.ItemStack nms = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nms.hasTag()){
            tag = new NBTTagCompound();
            nms.setTag(tag);
        }
        if (!tag.hasKey("ench")){
            tag.set("ench", new NBTTagList());
        }
        nms.setTag(tag);
        return CraftItemStack.asCraftMirror(nms);
    }
    
}
