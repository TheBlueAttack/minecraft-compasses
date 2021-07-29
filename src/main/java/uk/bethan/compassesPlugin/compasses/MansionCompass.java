package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class MansionCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "mansion_compass");

        ShapedRecipe mansionCompassRecipe = new ShapedRecipe(key, getItem());

        mansionCompassRecipe.shape("AIE", "IRI", "AIE");

        mansionCompassRecipe.setIngredient('E', Material.EMERALD);
        mansionCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        mansionCompassRecipe.setIngredient('R', Material.REDSTONE);
        mansionCompassRecipe.setIngredient('A', Material.GOLDEN_AXE);

        CompassesPlugin.plugin.getServer().addRecipe(mansionCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack mansionCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta mansionCompassMeta = mansionCompass.getItemMeta();
        mansionCompassMeta.setDisplayName(ChatColor.RED + "Mansion Compass");
        mansionCompass.setItemMeta(mansionCompassMeta);

        return mansionCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.WOODLAND_MANSION,
                5000,
                false
        );
    }
}
