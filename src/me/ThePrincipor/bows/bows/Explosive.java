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

public class Explosive extends JavaPlugin implements Listener{

    private ArrayList<Arrow> explosiveArrayList = new ArrayList<Arrow>();

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent event){
        if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.RED + "Explosive Bow")){
            explosiveArrayList.add((Arrow) event.getProjectile());
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        Projectile projectile = event.getEntity();
        if(explosiveArrayList.contains(projectile)){
            projectile.getWorld().createExplosion(projectile.getLocation(), 2);
            explosiveArrayList.remove(projectile);
        }
    }

}
