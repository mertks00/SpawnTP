package me.oyuncozucu.spawntp;

import me.oyuncozucu.spawntp.commands.SetSpawnCommand;
import me.oyuncozucu.spawntp.commands.SpawnCommand;
import me.oyuncozucu.spawntp.listeners.SpawnListeners;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnTP extends JavaPlugin implements CommandExecutor {
    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("reload").setExecutor(this);

        getServer().getPluginManager().registerEvents(new SpawnListeners(this),this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equals("reload")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("spawntp.reload")) {
                    this.reloadConfig();
                    String rmsg = getConfig().getString("config-reload-message");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', rmsg));

                }else {
                    String npsg = getConfig().getString("no-permission");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', npsg));

                }

            }

        }




        return true;
    }
}
