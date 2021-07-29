package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class DesertTemplesCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "desert_temple_compass");

        ShapedRecipe desertTempleCompassRecipe = new ShapedRecipe(key, getItem());

        desertTempleCompassRecipe.shape("CIC", "IRI", "CIC");

        desertTempleCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        desertTempleCompassRecipe.setIngredient('R', Material.REDSTONE);
        desertTempleCompassRecipe.setIngredient('C', Material.CLAY);

        CompassesPlugin.plugin.getServer().addRecipe(desertTempleCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack desertTempleCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta desertTempleCompassMeta = desertTempleCompass.getItemMeta();
        desertTempleCompassMeta.setDisplayName(ChatColor.YELLOW + "Desert Temple Compass");
        desertTempleCompass.setItemMeta(desertTempleCompassMeta);

        return desertTempleCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.DESERT_PYRAMID,
                5000,
                false
        );
    }
}
