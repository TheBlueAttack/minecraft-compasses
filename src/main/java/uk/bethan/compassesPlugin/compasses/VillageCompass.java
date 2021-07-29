package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class VillageCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "village_compass");

        ShapedRecipe villageCompassRecipe = new ShapedRecipe(key, getItem());

        villageCompassRecipe.shape("EIE", "IRI", "EIE");

        villageCompassRecipe.setIngredient('E', Material.EMERALD);
        villageCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        villageCompassRecipe.setIngredient('R', Material.REDSTONE);

        CompassesPlugin.plugin.getServer().addRecipe(villageCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack villageCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta villageCompassMeta = villageCompass.getItemMeta();
        villageCompassMeta.setDisplayName(ChatColor.GREEN + "Village Compass");
        villageCompass.setItemMeta(villageCompassMeta);

        return villageCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.VILLAGE,
                5000,
                false
        );
    }
}
