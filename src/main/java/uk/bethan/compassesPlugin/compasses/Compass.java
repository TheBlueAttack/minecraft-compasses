package uk.bethan.compassesPlugin.compasses;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Compass {
    Location getCompassTarget(Player player);
    void register();
    ItemStack getItem();
}
