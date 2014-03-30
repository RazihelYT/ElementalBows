package me.ThePrincipor.bows.bows;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Freezing extends JavaPlugin implements Listener {

	private ArrayList<Arrow> freezingArrayList = new ArrayList<Arrow>();

	@EventHandler
	public void onEntityShootBow(EntityShootBowEvent event) {
		if (event.getBow().getItemMeta().getDisplayName()
				.equals(ChatColor.AQUA + "Freezing Bow")) {
			freezingArrayList.add((Arrow) event.getProjectile());
		}
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		if (freezingArrayList.contains(event.getEntity())) {

			Location centre = event.getEntity().getLocation();

			int blockX = centre.getBlockX();
			int blockY = centre.getBlockY();
			int blockZ = centre.getBlockZ();

			for (int x = blockX - 5; x <= blockX + 5; x++) {
				for (int y = blockY - 5; y <= blockY + 5; y++) {
					for (int z = blockZ - 5; z <= blockZ + 5; z++) {	
						double distance = ((blockX - x) * (blockX - x)) + ((blockY - y) * (blockY - y)) + ((blockZ - z) * (blockZ - z));
						if (distance < 5 * 5) {
							Location location = new Location(centre.getWorld(), x, y, z);
							
							if(location.getBlock().getType().equals(Material.WATER) || location.getBlock().getType().equals(Material.STATIONARY_WATER)){
								location.getBlock().setType(Material.ICE);
							}else if(location.getBlock().getType().equals(Material.ICE)){
								location.getBlock().setType(Material.PACKED_ICE);
							}
							
						}
					}
				}
			}


			freezingArrayList.remove(event.getEntity());

		}
	}

}
