package me.ThePrincipor.bows.bows;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Glowstone implements Listener{
	
	private ArrayList<Arrow> glowstoneArrowArrayList = new ArrayList<Arrow>();
	
	@EventHandler
	public void onEntityShootBow(EntityShootBowEvent event){
		if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Glowstone Bow")){
			glowstoneArrowArrayList.add((Arrow) event.getProjectile());
		}
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event){
		Projectile projectile = event.getEntity();
		if(glowstoneArrowArrayList.contains(projectile)){
			projectile.getLocation().getBlock().setType(Material.GLOWSTONE);
			projectile.remove();

		}
	}

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event){
		if(event.getDamager().getType().equals(EntityType.ARROW)){
			event.setCancelled(true);
		}
		
	}
}
