package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class JungleTemplesCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "jungle_temple_compass");

        ShapedRecipe jungleTempleCompassRecipe = new ShapedRecipe(key, getItem());

        jungleTempleCompassRecipe.shape("MIM", "IRI", "MIM");

        jungleTempleCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        jungleTempleCompassRecipe.setIngredient('R', Material.REDSTONE);
        jungleTempleCompassRecipe.setIngredient('M', Material.MOSSY_COBBLESTONE);

        CompassesPlugin.plugin.getServer().addRecipe(jungleTempleCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack jungleTempleCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta jungleTempleCompassMeta = jungleTempleCompass.getItemMeta();
        jungleTempleCompassMeta.setDisplayName(ChatColor.YELLOW + "Jungle Temple Compass");
        jungleTempleCompass.setItemMeta(jungleTempleCompassMeta);

        return jungleTempleCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.JUNGLE_PYRAMID,
                5000,
                false
        );
    }
}
