package me.oyuncozucu.spawntp.commands;

import me.oyuncozucu.spawntp.SpawnTP;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnTP plugin;

    public SpawnCommand(SpawnTP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {

                player.teleport(location);

                String tmsg = plugin.getConfig().getString("teleport-message");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', tmsg));



            }else {
                String nmsg = plugin.getConfig().getString("no-location");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', nmsg));
            }


        }


        return true;
    }
}
