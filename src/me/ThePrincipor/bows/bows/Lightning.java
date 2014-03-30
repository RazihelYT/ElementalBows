package me.ThePrincipor.bows.bows;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Lightning extends JavaPlugin implements Listener {

    private ArrayList<Arrow> lightningArrayList = new ArrayList<Arrow>();

    @EventHandler
    public void onEntityBowShoot(EntityShootBowEvent event){
        if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Lightning Bow")){
            lightningArrayList.add((Arrow) event.getProjectile());
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        Projectile projectile = event.getEntity();
        if(lightningArrayList.contains(projectile)){
            projectile.getWorld().strikeLightning(projectile.getLocation());      
        }
    }

}
