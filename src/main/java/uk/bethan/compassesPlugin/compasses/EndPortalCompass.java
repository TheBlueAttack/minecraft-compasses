package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class EndPortalCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "end_portal_compass");

        ShapedRecipe endPortalCompassRecipe = new ShapedRecipe(key, getItem());

        endPortalCompassRecipe.shape("EIE", "IRI", "EIE");

        endPortalCompassRecipe.setIngredient('E', Material.ENDER_EYE);
        endPortalCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        endPortalCompassRecipe.setIngredient('R', Material.REDSTONE);

        CompassesPlugin.plugin.getServer().addRecipe(endPortalCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack endPortalCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta endPortalCompassMeta = endPortalCompass.getItemMeta();
        endPortalCompassMeta.setDisplayName(ChatColor.DARK_PURPLE + "End Portal Compass");
        endPortalCompass.setItemMeta(endPortalCompassMeta);

        return endPortalCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.STRONGHOLD,
                5000,
                false
        );
    }
}
