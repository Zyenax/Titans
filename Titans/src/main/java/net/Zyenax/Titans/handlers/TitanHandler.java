package net.Zyenax.Titans.handlers;

import net.Zyenax.Titans.Main;
import net.minecraft.server.v1_11_R1.EntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class TitanHandler implements Listener {

    public static HashMap<Player, Entity> titans = new HashMap<Player, Entity>();
    public static HashMap<String, BukkitTask> titanTP = new HashMap<String, BukkitTask>();
    private static Main plugin;

    public TitanHandler(Main hub) {
        TitanHandler.plugin = hub;
    }

    public static void spawnTitan(Player player) {
        /*IronGolem titan = (IronGolem)Bukkit.getWorld("world").spawn(player.getLocation(), IronGolem.class);
		titan.setSilent(true);
		titan.setCollidable(false);
		titan.setCustomName(titanName);
		titan.setCustomNameVisible(true);
		titan.setHealth(100.0);
		titan.setMaxHealth(100.0);
		titan.setPlayerCreated(true);
		titans.put(player, titan);*/
        EntityTypes.spawnEntity(new Titan(Bukkit.getWorld("world")), player.getLocation());
    }

    public static void titanTP(final Player player) {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        titanTP.put("titan", scheduler.runTaskTimer(plugin, new Runnable() {
            public void run() {
                if (titans.containsKey(player)) {
                    setRotation(titans.get(player), player.getLocation().getYaw(), player.getLocation().getPitch());
                }
            }
        }, 0, 1L));
    }

    public static void setRotation(Entity entity, float yaw, float pitch) {
        EntityLiving nmsEntity = (EntityLiving) ((CraftEntity) entity).getHandle();
        nmsEntity.pitch = pitch;
        nmsEntity.lastPitch = pitch;
        nmsEntity.yaw = yaw;
        nmsEntity.lastYaw = yaw;
        nmsEntity.aQ = yaw;
        nmsEntity.aR = yaw;
        nmsEntity.aO = yaw;
        nmsEntity.aP = yaw;
    }

    @EventHandler
    public void npcInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (titans.containsKey(player)) {
            if (event.getRightClicked() == titans.get(player)) {
                event.getRightClicked().setPassenger(player);
            }
        }
    }

    @EventHandler
    public void titanMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (titans.containsKey(player)) {
            titans.get(player).setVelocity(player.getVelocity().clone());
        }
    }

}
