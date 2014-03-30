package me.ThePrincipor.bows.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class Recipe {
	
	@SuppressWarnings("deprecation")
	public void create(ItemStack item, Material ingredient, int amount){
		ShapelessRecipe recipe = new ShapelessRecipe(item);
		recipe.addIngredient(Material.BOW);
		recipe.addIngredient(ingredient, amount);
		Bukkit.getServer().addRecipe(recipe);
	}

}
