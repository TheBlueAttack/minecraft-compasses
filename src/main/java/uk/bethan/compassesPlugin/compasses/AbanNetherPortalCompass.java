package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class AbanNetherPortalCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "aban_nether_portal_compass");

        ShapedRecipe abanNetherPortalCompassRecipe = new ShapedRecipe(key, getItem());

        abanNetherPortalCompassRecipe.shape("OIO", "IRI", "OIO");

        abanNetherPortalCompassRecipe.setIngredient('O', Material.OBSIDIAN);
        abanNetherPortalCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        abanNetherPortalCompassRecipe.setIngredient('R', Material.REDSTONE);

        CompassesPlugin.plugin.getServer().addRecipe(abanNetherPortalCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack abanNetherPortalCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta abanNetherPortalCompassMeta = abanNetherPortalCompass.getItemMeta();
        abanNetherPortalCompassMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Abandoned Nether Portal Compass");
        abanNetherPortalCompass.setItemMeta(abanNetherPortalCompassMeta);

        return abanNetherPortalCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.RUINED_PORTAL,
                5000,
                false
        );
    }
}
