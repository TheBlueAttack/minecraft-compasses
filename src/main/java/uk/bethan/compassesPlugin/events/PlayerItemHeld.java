package uk.bethan.compassesPlugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import uk.bethan.compassesPlugin.CompassesPlugin;
import uk.bethan.compassesPlugin.compasses.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerItemHeld implements Listener {

    protected List<Compass> compasses = new ArrayList<>();

    public PlayerItemHeld () {
        compasses.add(new VillageCompass());
        compasses.add(new JungleTemplesCompass());
        compasses.add(new MansionCompass());
        compasses.add(new SeaMonumentCompass());
        compasses.add(new AbanNetherPortalCompass());
        compasses.add(new PillagerCompass());
        compasses.add(new ShipWreckCompass());
        compasses.add(new DesertTemplesCompass());
        compasses.add(new EndPortalCompass());
        compasses.add(new SuperCompass());
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {

        Player player = event.getPlayer();

        ItemStack itemInHand = player.getInventory().getItem(event.getNewSlot());
        ItemStack preItemInHand = player.getInventory().getItem(event.getPreviousSlot());

        for (Compass compass : compasses) {

            if (itemInHand != null && itemInHand.equals(compass.getItem())) {
                CompassesPlugin.setCompassLocationForPlayer(player, compass);

                return;

            } else if (preItemInHand != null && preItemInHand.equals(compass.getItem())) {
                player.setCompassTarget(CompassesPlugin.plugin.getServer().getWorlds().get(0).getSpawnLocation());
            }
        }


    }
}
