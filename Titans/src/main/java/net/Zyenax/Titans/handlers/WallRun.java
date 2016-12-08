package net.Zyenax.Titans.handlers;

import net.Zyenax.Titans.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;

public class WallRun implements Listener {

    public static HashMap<Player, Player> run = new HashMap<Player, Player>();
    private Main plugin;

    public WallRun(Main listener) {
        this.plugin = listener;
    }

    @EventHandler
    public void playermove(PlayerMoveEvent e) {
        final Player player = e.getPlayer();
        if (!run.containsKey(player)) {
            if ((player.getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.AIR)
                    && (player.getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.WATER)
                    && (player.getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.STATIONARY_WATER)) {
                player.setVelocity(player.getLocation().getDirection().multiply(0.8).setY(0.8));
                run.put(player, player);
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.runTaskLater(plugin, new Runnable() {
                    public void run() {
                        run.remove(player);
                    }
                }, 3 * 20);
            } else if ((player.getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.AIR)
                    && (player.getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.WATER)
                    && (player.getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.STATIONARY_WATER)) {
                player.setVelocity(player.getLocation().getDirection().multiply(0.8).setY(0.8));
                run.put(player, player);
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.runTaskLater(plugin, new Runnable() {
                    public void run() {
                        run.remove(player);
                    }
                }, 3 * 20);
            } else if ((player.getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.AIR)
                    && (player.getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.WATER)
                    && (player.getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.STATIONARY_WATER)) {
                player.setVelocity(player.getLocation().getDirection().multiply(0.8).setY(0.8));
                run.put(player, player);
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.runTaskLater(plugin, new Runnable() {
                    public void run() {
                        run.remove(player);
                    }
                }, 3 * 20);
            } else if ((player.getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.AIR)
                    && (player.getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.WATER)
                    && (player.getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.STATIONARY_WATER)) {
                player.setVelocity(player.getLocation().getDirection().multiply(0.8).setY(0.8));
                run.put(player, player);
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.runTaskLater(plugin, new Runnable() {
                    public void run() {
                        run.remove(player);
                    }
                }, 3 * 20);
            }
        }
    }

}
