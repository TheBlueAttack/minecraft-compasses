package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class SuperCompass implements Compass {

    @Override
    public Location getCompassTarget(Player player) {
        return null;
    }

    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "super_compass");

        ShapedRecipe superCompassRecipe = new ShapedRecipe(key, getItem());

        superCompassRecipe.shape("DeD", "eEe", "DeD");

        superCompassRecipe.setIngredient('e', Material.EMERALD_BLOCK);
        superCompassRecipe.setIngredient('E', Material.ENCHANTED_GOLDEN_APPLE);
        superCompassRecipe.setIngredient('D', Material.DIAMOND_BLOCK);

        CompassesPlugin.plugin.getServer().addRecipe(superCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack superCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta superCompassMeta = superCompass.getItemMeta();
        superCompassMeta.setDisplayName(ChatColor.MAGIC + "Super Compass");
        superCompass.setItemMeta(superCompassMeta);

        return superCompass;
    }
}
