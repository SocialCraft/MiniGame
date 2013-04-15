package com.stirante.wiz3ard.MiniGame.utils;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.server.v1_5_R2.Packet63WorldParticles;
import net.minecraft.server.v1_5_R2.PlayerConnection;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_5_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public enum Particles {
    
    LARGE_EXPLOSION("largeexplode"),
    FIREWORK_SPARK("fireworksSpark"),
    BUBBLE("bubble"),
    SUSPENDED("suspended"),
    DEPTH_SUSPEND("depthsuspend"),
    TOWN_AURA("townaura"),
    CRITICAL_HIT("crit"),
    MAGICAL_CRITICAL_HIT("magicCrit"),
    SMOKE("smoke"),
    MOB_SPELL("mobSpell"),
    MOB_SPELL_AMBIENT("mobSpellAmbient"),
    SPELL("spell"),
    INSTANT_SPELL("instantSpell"),
    WITCH_MAGIC("witchMagic"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchantmenttable"),
    EXPLODE("explode"),
    FLAME("flame"),
    LAVA("lava"),
    FOOTSTEP("footstep"),
    SPLASH("splash"),
    LARGE_SMOKE("largesmoke"),
    CLOUD("cloud"),
    REDSTONE("reddust"),
    SNOWBALL_POOF("snowballpoof"),
    DROP_WATER("dripWater"),
    DROP_LAVA("dripLava"),
    SNOW_SHOVEL("snowshovel"),
    SLIME("slime"),
    HEART("heart"),
    ANGRY_VILLAGER("angryVillager"),
    HAPPY_VILLAGER("happyVillager"),
    HUGE_EXPLOSION("hugeexplosion");
    
    private String id;
    
    private Particles(String name) {
        id = name;
    }
    
    private static Object setPrivateField(String fieldName, Object instance, Object value) {
        try {
            Field field = null;
            if (instance instanceof Class<?>) field = ((Class<?>) instance).getDeclaredField(fieldName);
            else field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (instance instanceof Class) field.set(null, value);
            else field.set(instance, value);
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while using private field \"" + fieldName + "\"", t);
        }
        return value;
    }
    
    public void spawnParticle(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int numberOfParticles) {
        try {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
            Packet63WorldParticles packet = new Packet63WorldParticles();
            setPrivateField("a", packet, id);
            setPrivateField("b", packet, (float) location.getX());
            setPrivateField("c", packet, (float) location.getY());
            setPrivateField("d", packet, (float) location.getZ());
            setPrivateField("e", packet, offsetX);
            setPrivateField("f", packet, offsetY);
            setPrivateField("g", packet, offsetZ);
            setPrivateField("h", packet, speed);
            setPrivateField("i", packet, numberOfParticles);
            connection.sendPacket(packet);
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while spawning a particle", t);
        }
    }
    
    public void spawnParticle(Location location, float offsetX, float offsetY, float offsetZ, float speed, int numberOfParticles) {
        try {
            Packet63WorldParticles packet = new Packet63WorldParticles();
            setPrivateField("a", packet, id);
            setPrivateField("b", packet, (float) location.getX());
            setPrivateField("c", packet, (float) location.getY());
            setPrivateField("d", packet, (float) location.getZ());
            setPrivateField("e", packet, offsetX);
            setPrivateField("f", packet, offsetY);
            setPrivateField("g", packet, offsetZ);
            setPrivateField("h", packet, speed);
            setPrivateField("i", packet, numberOfParticles);
            List<Player> players = location.getWorld().getPlayers();
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
                connection.sendPacket(packet);
            }
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while spawning a particle", t);
        }
    }
    
    public static void spawnTileCrack(Player player, int blockId, int data, Location location, float offsetX, float offsetY, float offsetZ, float speed, int numberOfParticles) {
        try {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
            Packet63WorldParticles packet = new Packet63WorldParticles();
            setPrivateField("a", packet, "tilecrack_" + blockId + "_" + data);
            setPrivateField("b", packet, (float) location.getX());
            setPrivateField("c", packet, (float) location.getY());
            setPrivateField("d", packet, (float) location.getZ());
            setPrivateField("e", packet, offsetX);
            setPrivateField("f", packet, offsetY);
            setPrivateField("g", packet, offsetZ);
            setPrivateField("h", packet, speed);
            setPrivateField("i", packet, numberOfParticles);
            connection.sendPacket(packet);
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while spawning a particle", t);
        }
    }
    
    public static void spawnTileCrack(int blockId, int data, Location location, float offsetX, float offsetY, float offsetZ, float speed, int numberOfParticles) {
        try {
            Packet63WorldParticles packet = new Packet63WorldParticles();
            setPrivateField("a", packet, "tilecrack_" + blockId + "_" + data);
            setPrivateField("b", packet, (float) location.getX());
            setPrivateField("c", packet, (float) location.getY());
            setPrivateField("d", packet, (float) location.getZ());
            setPrivateField("e", packet, offsetX);
            setPrivateField("f", packet, offsetY);
            setPrivateField("g", packet, offsetZ);
            setPrivateField("h", packet, speed);
            setPrivateField("i", packet, numberOfParticles);
            List<Player> players = location.getWorld().getPlayers();
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
                connection.sendPacket(packet);
            }
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while spawning a particle", t);
        }
    }
    
    public static void spawnIconCrack(Player player, int itemId, Location location, float offsetX, float offsetY, float offsetZ, float speed, int numberOfParticles) {
        try {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
            Packet63WorldParticles packet = new Packet63WorldParticles();
            setPrivateField("a", packet, "tilecrack_" + itemId);
            setPrivateField("b", packet, (float) location.getX());
            setPrivateField("c", packet, (float) location.getY());
            setPrivateField("d", packet, (float) location.getZ());
            setPrivateField("e", packet, offsetX);
            setPrivateField("f", packet, offsetY);
            setPrivateField("g", packet, offsetZ);
            setPrivateField("h", packet, speed);
            setPrivateField("i", packet, numberOfParticles);
            connection.sendPacket(packet);
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while spawning a particle", t);
        }
    }
    
    public static void spawnIconCrack(int itemId, Location location, float offsetX, float offsetY, float offsetZ, float speed, int numberOfParticles) {
        try {
            Packet63WorldParticles packet = new Packet63WorldParticles();
            setPrivateField("a", packet, "tilecrack_" + itemId);
            setPrivateField("b", packet, (float) location.getX());
            setPrivateField("c", packet, (float) location.getY());
            setPrivateField("d", packet, (float) location.getZ());
            setPrivateField("e", packet, offsetX);
            setPrivateField("f", packet, offsetY);
            setPrivateField("g", packet, offsetZ);
            setPrivateField("h", packet, speed);
            setPrivateField("i", packet, numberOfParticles);
            List<Player> players = location.getWorld().getPlayers();
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
                connection.sendPacket(packet);
            }
        }
        catch (Throwable t) {
            throw new RuntimeException("Unexpected throwable while spawning a particle", t);
        }
    }
}