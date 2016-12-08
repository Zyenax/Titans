package net.Zyenax.Titans;

import net.Zyenax.Titans.commands.TitanCommand;
import net.Zyenax.Titans.handlers.Titan;
import net.Zyenax.Titans.handlers.TitanHandler;
import net.Zyenax.Titans.handlers.WallRun;
import net.Zyenax.Titans.menus.TitanMenu;
import net.Zyenax.Titans.utils.Packets;
import net.Zyenax.Titans.utils.Utils;
import net.minecraft.server.v1_11_R1.EntityTypes;
import net.minecraft.server.v1_11_R1.MinecraftKey;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        registerListeners();
        registerCommands();
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(Utils.color("&8[&cTitans&8] &aHas been enabled!"));
        
        
        /*MinecraftKey key = new MinecraftKey("titan");
        EntityTypes.b.a(Titan.class);
        EntityTypes.d.add(key);

        while (EntityTypes.g.size() <= 60) {
            EntityTypes.g.add(null);
        }

        EntityTypes.g.set(60, "Titan");*/
    }

    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(Utils.color("&8[&cTitans&8] &cHas been disabled!"));
    }

    public void registerListeners() {
        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new TitanHandler(this), this);
        manager.registerEvents(new TitanMenu(this), this);
        manager.registerEvents(new TitanCommand(this), this);
        manager.registerEvents(new Utils(this), this);
        manager.registerEvents(new Packets(this), this);
        manager.registerEvents(new PlayerJoin(this), this);
        manager.registerEvents(new WallRun(this), this);
    }

    public void registerCommands() {
        getCommand("titan").setExecutor(new TitanCommand(this));
    }

}
