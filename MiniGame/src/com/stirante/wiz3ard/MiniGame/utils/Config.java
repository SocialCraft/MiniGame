package com.stirante.wiz3ard.MiniGame.utils;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
    private static FileConfiguration config;
    private static FileConfiguration lang;
    
    public static void init(JavaPlugin plugin) {
        config = plugin.getConfig();
        config.options().copyDefaults(true);
        plugin.saveConfig();
        plugin.reloadConfig();
        plugin.saveResource("plugin.lang", false);
        lang = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "plugin.lang"));
    }
    
    public static String translateMessage(String node, String... params) {
        return formatColor(formatParams(lang.getString("error." + node), params));
    }
    
    public static String translateError(String node, String... params) {
        return ChatColor.DARK_RED + formatParams(lang.getString("error." + node), params);
    }
    
    public static String getRawString(String node, String... params){
        return formatParams(config.getString(node), params);
    }
    public static String getColoredString(String node){
        return formatColor(config.getString(node));
    }
    
    public static String formatColor(String text){
        for (int i = 0; i < ChatColor.values().length; i++) {
            text = text.replaceAll(";" + ChatColor.values()[i].name().toLowerCase() + ";", ChatColor.values()[i].toString());
            text = text.replaceAll(";" + ChatColor.values()[i].name().toLowerCase().replaceAll("_", "") + ";", ChatColor.values()[i].toString());
            text = text.replaceAll(";" + ChatColor.values()[i].name().toUpperCase() + ";", ChatColor.values()[i].toString());
            text = text.replaceAll(";" + ChatColor.values()[i].name().toUpperCase().replaceAll("_", "") + ";", ChatColor.values()[i].toString());
        }
        return text;
    }
    
    public static String formatParams(String text, String[] params){
        for (int i = 0; i < params.length; i++) {
            text = text.replaceAll(";" + i + ";", params[i]);
        }
        return text;
    }
    
    public static int getInt(String node) {
        return Integer.parseInt(config.getString(node));
    }
    
    public static float getFloat(String node) {
        return Float.parseFloat(config.getString(node));
    }
    
    public static double getDouble(String node) {
        return Double.parseDouble(config.getString(node));
    }
    
    public static int getTicks(String node) {
        String[] split = config.getString(node).split("\\+");
        int ticks = 0;
        for (String num : split) {
            if (num.contains("d")) {
                ticks += Integer.parseInt(num.replace("d", "")) * 1728000;
            }
            else if (num.contains("h")) {
                ticks += Integer.parseInt(num.replace("h", "")) * 72000;
            }
            else if (num.contains("m")) {
                ticks += Integer.parseInt(num.replace("m", "")) * 1200;
            }
            else if (num.contains("s")) {
                ticks += Integer.parseInt(num.replace("s", "")) * 20;
            }
            else if (num.contains("t")) {
                ticks += Integer.parseInt(num.replace("t", ""));
            }
        }
        return ticks;
    }
    
}
