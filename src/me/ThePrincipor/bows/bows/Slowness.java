package me.ThePrincipor.bows.bows;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class Slowness extends JavaPlugin implements Listener{

    private ArrayList<Arrow> slownessArrayList = new ArrayList<Arrow>();

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent event){
        if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Slowness Bow")){
            slownessArrayList.add((Arrow) event.getProjectile());
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        if(slownessArrayList.contains(event.getDamager())){
            LivingEntity entity = (LivingEntity) event.getEntity();
            entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 3));
        }
    }

}
