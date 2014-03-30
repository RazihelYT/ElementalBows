package me.ThePrincipor.bows.bows;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Rapidfire extends JavaPlugin implements Listener{

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent event){
        if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rapidfire Bow")){
            event.getProjectile().setVelocity(event.getEntity().getLocation().getDirection().multiply(3));
        }
    }

}
