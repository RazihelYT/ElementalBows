package me.ThePrincipor.bows.bows;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Teleportation extends JavaPlugin implements Listener{

    private ArrayList<Arrow> teleportationArrayList = new ArrayList<Arrow>();

    @EventHandler
    public void onEntityBowShoot(EntityShootBowEvent event){
        if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Teleportation Bow")){
            teleportationArrayList.add((Arrow) event.getProjectile());
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if(teleportationArrayList.contains(event.getEntity())){
            event.getEntity().getShooter().teleport(event.getEntity().getLocation());
            teleportationArrayList.remove(event.getEntity());
        }
    }
}
