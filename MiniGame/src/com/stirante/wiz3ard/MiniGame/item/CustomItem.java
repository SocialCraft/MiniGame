package com.stirante.wiz3ard.MiniGame.item;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.stirante.wiz3ard.MiniGame.utils.Glow;

public abstract class CustomItem {
    
    public ItemStack getItem() {
        ItemStack item = new ItemStack(getBaseMaterial());
        
        item.getItemMeta().setDisplayName(getDisplayName());
        if (getLore() != null)
            item.getItemMeta().setLore(getLore());
        
        item = Glow.addGlow(item);
        
        return item;
    }
    
    public abstract Material getBaseMaterial();
    
    public abstract boolean isGlowing();
    
    public abstract String getDisplayName();
    
    public abstract String getName();
    
    public abstract List<String> getLore();
    
    public abstract void onEntityAttacked(EntityDamageByEntityEvent e);
    
    public boolean isItem(ItemStack item) {
        if (item.getType() != getBaseMaterial())
            return false;
        if (!item.getItemMeta().hasDisplayName())
            return false;
        if (!item.getItemMeta().hasLore() && getLore() != null)
            return false;
        if (!item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RESET + getDisplayName()))
            return false;
        return true;
    }
    
}
