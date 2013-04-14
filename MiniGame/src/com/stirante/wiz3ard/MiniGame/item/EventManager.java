package com.stirante.wiz3ard.MiniGame.item;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventManager implements Listener {
    
    private HashMap<String, CustomItem> items = new HashMap<String, CustomItem>();
    
    public boolean registerItem(CustomItem item) {
        if (item == null)
            return false;
        if (items.containsKey(item.getName()))
            return false;
        items.put(item.getName(), item);
        return true;
    }
    
    @EventHandler
    public void onEntityAttack(EntityDamageByEntityEvent e) {
        Object[] keys = items.keySet().toArray();
        for (Object name : keys) {
            if (items.get(name).isItem(((Player)e.getDamager()).getItemInHand())){
                items.get(name).onEntityAttacked(e);
                return;
            }
        }
        
    }
    
}
