package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class PillagerCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "pillager_compass");

        ShapedRecipe pillagerCompassRecipe = new ShapedRecipe(key, getItem());

        pillagerCompassRecipe.shape("CIC", "IRI", "CIC");

        pillagerCompassRecipe.setIngredient('C', Material.CROSSBOW);
        pillagerCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        pillagerCompassRecipe.setIngredient('R', Material.REDSTONE);

        CompassesPlugin.plugin.getServer().addRecipe(pillagerCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack pillagerCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta pillagerCompassMeta = pillagerCompass.getItemMeta();
        pillagerCompassMeta.setDisplayName(ChatColor.DARK_GREEN + "Pillager Compass");
        pillagerCompass.setItemMeta(pillagerCompassMeta);

        return pillagerCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.PILLAGER_OUTPOST,
                5000,
                false
        );
    }
}
