package com.stirante.wiz3ard.MiniGame.item;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class EventManager implements Listener {
    
    private HashMap<String, CustomItem> items = new HashMap<String, CustomItem>();
    
    private static EventManager instance;
    
    public EventManager(){
        instance = this;
    }
    
    public static boolean registerItem(CustomItem item) {
        if (instance == null)
            throw new RuntimeException("You have to initialize EventManager!");
        
        if (item == null) return false;
        if (instance.items.containsKey(item.getName())) return false;
        instance.items.put(item.getName(), item);
        return true;
    }
    
    @EventHandler
    public void onEntityAttack(EntityDamageByEntityEvent e) {
        Object[] keys = items.keySet().toArray();
        for (Object name : keys) {
            if (items.get(name).isItem(((Player) e.getDamager()).getItemInHand())) {
                items.get(name).onEntityAttacked(e);
                return;
            }
        }
    }
    
    @EventHandler
    public void onItemUse(PlayerInteractEvent e) {
        Object[] keys = items.keySet().toArray();
        for (Object name : keys) {
            if (items.get(name).isItem(e.getItem())) {
                items.get(name).onItemUse(e);
                return;
            }
        }
    }
    
    @EventHandler
    public void onItemOnEntityUse(PlayerInteractEntityEvent e) {
        Object[] keys = items.keySet().toArray();
        for (Object name : keys) {
            if (items.get(name).isItem(e.getPlayer().getItemInHand())) {
                items.get(name).onItemOnEntityUse(e);
                return;
            }
        }
    }
    
    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent e) {
        Object[] keys = items.keySet().toArray();
        for (Object name : keys) {
            if (items.get(name).isItem(e.getPlayer().getItemInHand())) {
                items.get(name).onItemConsume(e);
                return;
            }
        }
    }
    
}
