package net.Zyenax.Titans.commands;

import net.Zyenax.Titans.Main;
import net.Zyenax.Titans.handlers.EntityTypes;
import net.Zyenax.Titans.handlers.Titan;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TitanCommand implements Listener, CommandExecutor {

    @SuppressWarnings("unused")
    private Main plugin;

    public TitanCommand(Main hub) {
        this.plugin = hub;
    }

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("titan")) {
                //TitanMenu.Menu(player);
                EntityTypes.spawnEntity(new Titan(player.getWorld()), player.getLocation());
            }
        }
        return true;
    }

}
