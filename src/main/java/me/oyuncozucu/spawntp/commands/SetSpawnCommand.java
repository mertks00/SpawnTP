package me.oyuncozucu.spawntp.commands;

import me.oyuncozucu.spawntp.SpawnTP;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class SetSpawnCommand implements CommandExecutor {
    private final SpawnTP plugin;
    public SetSpawnCommand(SpawnTP plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;
            if (player.hasPermission("spawntp.admin")) {

                Location location = player.getLocation();

                plugin.getConfig().set("spawn",location);
                plugin.saveConfig();

                String smsg = plugin.getConfig().getString("setspawn-message");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', smsg));

            } else {
                String nmsg = plugin.getConfig().getString("no-permission");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', nmsg));
            }


        }
        return true;
    }
}
