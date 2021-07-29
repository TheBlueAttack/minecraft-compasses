package uk.bethan.compassesPlugin.GUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import uk.bethan.compassesPlugin.CompassesPlugin;
import uk.bethan.compassesPlugin.compasses.*;

import java.util.ArrayList;
import java.util.List;

public class SuperCompassGUI implements Listener {
    final String INVENTORY_NAME = "Compasses";

    public Inventory inv;
    protected List<Compass> compasses = new ArrayList<>();

    public SuperCompassGUI() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 9, INVENTORY_NAME);

        compasses.add(new VillageCompass());
        compasses.add(new JungleTemplesCompass());
        compasses.add(new MansionCompass());
        compasses.add(new SeaMonumentCompass());
        compasses.add(new AbanNetherPortalCompass());
        compasses.add(new PillagerCompass());
        compasses.add(new ShipWreckCompass());
        compasses.add(new DesertTemplesCompass());
        compasses.add(new EndPortalCompass());

        int slot = 0;

        for (Compass compass : compasses) {
            inv.setItem(slot, compass.getItem());
            slot++;
        }

    }

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        SuperCompass superCompass = new SuperCompass();

        if(player.getInventory().getItemInMainHand().equals(superCompass.getItem())) {
            player.openInventory(inv);
        }
    }

    @EventHandler
    public void getClickedInventory (InventoryClickEvent event) {

        if (!event.getView().getTitle().equals(INVENTORY_NAME)) {
            return;
        }

        Inventory clickedInventory = event.getClickedInventory(); //Optimise
        Player player = (Player) event.getWhoClicked();

        for (Compass compass : compasses) {

            if (clickedInventory != null && clickedInventory.getItem(event.getSlot()).equals(compass.getItem())) {
                player.closeInventory();

                CompassesPlugin.setCompassLocationForPlayer(player, compass);

                return;
            }
        }
    }
}
