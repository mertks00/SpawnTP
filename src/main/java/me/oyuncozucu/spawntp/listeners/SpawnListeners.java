package me.oyuncozucu.spawntp.listeners;

import me.oyuncozucu.spawntp.SpawnTP;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    public final SpawnTP plugin;

    public SpawnListeners(SpawnTP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        if (e.getPlayer().hasPlayedBefore()) {

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {

                e.getPlayer().teleport(location);

            }

        }
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {

        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
