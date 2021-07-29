package uk.bethan.compassesPlugin.compasses;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import uk.bethan.compassesPlugin.CompassesPlugin;

public class SeaMonumentCompass implements Compass {
    @Override
    public void register() {

        //Crafting Recipe
        NamespacedKey key = new NamespacedKey(CompassesPlugin.plugin, "sea_monument_compass");

        ShapedRecipe seaMonumentCompassRecipe = new ShapedRecipe(key, getItem());

        seaMonumentCompassRecipe.shape("PIT", "IRI", "SIC");

        seaMonumentCompassRecipe.setIngredient('P', Material.PUFFERFISH);
        seaMonumentCompassRecipe.setIngredient('I', Material.IRON_INGOT);
        seaMonumentCompassRecipe.setIngredient('R', Material.REDSTONE);
        seaMonumentCompassRecipe.setIngredient('T', Material.TROPICAL_FISH);
        seaMonumentCompassRecipe.setIngredient('S', Material.SALMON);
        seaMonumentCompassRecipe.setIngredient('C', Material.COD);

        CompassesPlugin.plugin.getServer().addRecipe(seaMonumentCompassRecipe);
    }

    @Override
    public ItemStack getItem() {
        //Create Item
        ItemStack seaMonumentCompass = new ItemStack(Material.COMPASS);

        //Meta Data
        ItemMeta seaMonumentCompassMeta = seaMonumentCompass.getItemMeta();
        seaMonumentCompassMeta.setDisplayName(ChatColor.BLUE + "Sea Monument Compass");
        seaMonumentCompass.setItemMeta(seaMonumentCompassMeta);

        return seaMonumentCompass;
    }

    @Override
    public Location getCompassTarget(Player player) {
        return player.getLocation().getWorld().locateNearestStructure(
                player.getLocation(),
                StructureType.OCEAN_MONUMENT,
                5000,
                false
        );
    }
}
