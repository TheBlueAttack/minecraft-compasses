package uk.bethan.compassesPlugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import uk.bethan.compassesPlugin.GUI.SuperCompassGUI;
import uk.bethan.compassesPlugin.compasses.*;
import uk.bethan.compassesPlugin.events.PlayerItemHeld;

public class CompassesPlugin extends JavaPlugin {

    public static Plugin plugin;

    public CompassesPlugin() {plugin = this;}

    public static void setCompassLocationForPlayer(Player player, Compass compass) {
        Location location = compass.getCompassTarget(player);

        if (location != null) {
            player.setCompassTarget(location);
        }
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerItemHeld(), plugin);

        (new VillageCompass()).register();
        (new PillagerCompass()).register();
        (new SeaMonumentCompass()).register();
        (new AbanNetherPortalCompass()).register();
        (new DesertTemplesCompass()).register();
        (new EndPortalCompass()).register();
        (new MansionCompass()).register();
        (new ShipWreckCompass()).register();
        (new JungleTemplesCompass()).register();
        (new SuperCompass()).register();

        getServer().getPluginManager().registerEvents(new SuperCompassGUI(), plugin);
    }
}