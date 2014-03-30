package me.ThePrincipor.bows;

import me.ThePrincipor.bows.bows.Explosive;
import me.ThePrincipor.bows.bows.Freezing;
import me.ThePrincipor.bows.bows.Glowstone;
import me.ThePrincipor.bows.bows.Lightning;
import me.ThePrincipor.bows.bows.Poison;
import me.ThePrincipor.bows.bows.Rapidfire;
import me.ThePrincipor.bows.bows.Slowness;
import me.ThePrincipor.bows.bows.Teleportation;
import me.ThePrincipor.bows.crafting.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{

    Items items = new Items();

    ItemStack explosiveBow = items.create(ChatColor.RED + "Explosive Bow");
    ItemStack freezingBow = items.create(ChatColor.AQUA + "Freezing Bow");
    ItemStack glowstoneBow = items.create(ChatColor.YELLOW + "Glowstone Bow");
    ItemStack lightingBow = items.create(ChatColor.GOLD + "Lightning Bow");
    ItemStack poisonBow = items.create(ChatColor.GREEN + "Poison Bow");
    ItemStack rapidfireBow = items.create(ChatColor.ITALIC + "Rapidfire Bow");
    ItemStack slownessBow = items.create(ChatColor.DARK_AQUA + "Slowness Bow");
    ItemStack teleportationBow = items.create(ChatColor.DARK_GREEN + "Teleportation Bow");


    public void onEnable(){
        Recipe recipe = new Recipe();
    	
        recipe.create(explosiveBow, Material.TNT, 1);
        recipe.create(freezingBow, Material.ICE, 1);
        recipe.create(glowstoneBow, Material.GLOWSTONE, 1);
        recipe.create(lightingBow, Material.NETHER_STAR, 1);
        recipe.create(poisonBow, Material.FERMENTED_SPIDER_EYE, 1);
        recipe.create(rapidfireBow, Material.FEATHER, 5);
        recipe.create(slownessBow, Material.ANVIL, 1);
        recipe.create(teleportationBow, Material.ENDER_PEARL, 1);
        
        Bukkit.getPluginManager().registerEvents(new Explosive(), this);
        Bukkit.getPluginManager().registerEvents(new Freezing(), this);
        Bukkit.getPluginManager().registerEvents(new Glowstone(), this);
        Bukkit.getPluginManager().registerEvents(new Lightning(), this);
        Bukkit.getPluginManager().registerEvents(new Poison(), this);
        Bukkit.getPluginManager().registerEvents(new Rapidfire(), this);
        Bukkit.getPluginManager().registerEvents(new Slowness(), this);
        Bukkit.getPluginManager().registerEvents(new Teleportation(), this);
    }

}
