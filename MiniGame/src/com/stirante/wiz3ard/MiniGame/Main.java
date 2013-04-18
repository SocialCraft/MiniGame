package com.stirante.wiz3ard.MiniGame;

import org.bukkit.plugin.java.JavaPlugin;

import com.stirante.wiz3ard.MiniGame.item.EventManager;

public class Main extends JavaPlugin {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventManager(), this);
        registerItems();
    }
    private void registerItems() {
        
    }
    public void onDisable() {
        
    }
}
