package net.Zyenax.Titans.menus;

import net.Zyenax.Titans.Main;
import net.Zyenax.Titans.handlers.TitanHandler;
import net.Zyenax.Titans.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TitanMenu implements Listener {

    public static Inventory inv;

    @SuppressWarnings("unused")
    private static Main plugin;

    public TitanMenu(Main listener) {
        TitanMenu.plugin = listener;
        Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Titan Selector"));
        inv = inventory;
        Border();
        Titan1();
    }

    public static void Menu(final Player p) {
        p.openInventory(inv);
    }

    public static void Border() {
        ItemStack border = Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, Utils.color(" "), null);
        inv.setItem(0, border);
        inv.setItem(1, border);
        inv.setItem(2, border);
        inv.setItem(3, border);
        inv.setItem(4, border);
        inv.setItem(5, border);
        inv.setItem(6, border);
        inv.setItem(7, border);
        inv.setItem(8, border);
        inv.setItem(9, border);
        inv.setItem(17, border);
        inv.setItem(18, border);
        inv.setItem(26, border);
        inv.setItem(27, border);
        inv.setItem(35, border);
        inv.setItem(36, border);
        inv.setItem(37, border);
        inv.setItem(38, border);
        inv.setItem(39, border);
        inv.setItem(40, border);
        inv.setItem(41, border);
        inv.setItem(42, border);
        inv.setItem(43, border);
        inv.setItem(44, border);
    }

    public static void Titan1() {
        ItemStack item = Utils.createItem(Material.ANVIL, 1, 0, Utils.color("&c&lBRUTE"), null);
        inv.setItem(11, item);
    }

    @EventHandler
    public void menuClickEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(Utils.color("&8Titan Selector"))) {
            e.setCancelled(true);
            if (e.getWhoClicked() instanceof Player) {
                if (e.getInventory() != null) {
                    if (!(e.getCurrentItem() == null)) {
                        if (!(e.getCurrentItem().getType() == Material.AIR)) {

                            if (e.getCurrentItem().getType().equals(Material.ANVIL)) {
                                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&c&lBRUTE"))) {
                                    e.setCancelled(true);
                                    TitanHandler.spawnTitan(p);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
                                }
                            }


                            //BORDER
                            if (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)) {
                                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(" "))) {
                                    e.setCancelled(true);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, Integer.MAX_VALUE, Integer.MAX_VALUE);
                                }
                            }


                        }
                    }
                }
            }
        }
    }

}
