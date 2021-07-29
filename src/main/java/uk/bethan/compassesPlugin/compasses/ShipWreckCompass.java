package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class ShipWreckCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "ship_wreck_compass");

        ShapedRecipe shipWreckCompassRecipe = new ShapedRecipe(key, getItem());

        shipWreckCompassRecipe.shape("PIP", "IRI", "PIP");

        shipWreckCompassRecipe.setIngredient('P', Material.MAP);
        shipWreckCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        shipWreckCompassRecipe.setIngredient('R', Material.REDSTONE);

        CompassesPlugin.plugin.getServer().addRecipe(shipWreckCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack shipWreckCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta shipWreckCompassMeta = shipWreckCompass.getItemMeta();
        shipWreckCompassMeta.setDisplayName(ChatColor.RED + "Ship Wreck Compass");
        shipWreckCompass.setItemMeta(shipWreckCompassMeta);

        return shipWreckCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.SHIPWRECK,
                5000,
                false
        );
    }
}
