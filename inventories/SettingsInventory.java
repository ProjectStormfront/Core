package core.deagan.core.inventories;

import core.deagan.core.Core;
import core.deagan.core.utils.CScoreboard;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SettingsInventory {
    public void openSettingsInventory(InventoryGui gui, Player p) {
        gui.setFiller(new ItemStack(Material.GLASS_PANE));
        gui.addElement(new StaticGuiElement('s',
                new ItemStack(Material.REDSTONE),
                1, // Display a number as the item count
                click -> {
                    if (click.getEvent().getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Settings")) {
                        p.closeInventory();
                        openOverallSettingsInventory(gui, p);
                        return true; // returning true will cancel the click event and stop taking the item
                    }
                    return false; // returning false will not cancel the initial click event to the gui
                },
                ChatColor.RED + "Settings",
                ChatColor.RED + "Overall Settings."));
        gui.show(p);
    }
    public void openOverallSettingsInventory(InventoryGui gui, Player p) {
        gui.setFiller(new ItemStack(Material.GLASS_PANE));
        gui.addElement(new StaticGuiElement('s',
                new ItemStack(Material.FEATHER),
                1,
                click -> {
                    if (click.getEvent().getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Scoreboard Visibility")) {
                        p.closeInventory();
                        if(Core.players.get(p.getUniqueId()).isScoreboardVisibility()) {
                            p.sendMessage(ChatColor.RED + "You have toggled scoreboard visibility off.");
                            Core.players.get(p.getUniqueId()).setScoreboardVisibility(false);
                            p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
                            return true;
                        }
                        if(!Core.players.get(p.getUniqueId()).isScoreboardVisibility()) {
                            p.sendMessage(ChatColor.GREEN + "You have toggled scoreboard visibility on.");
                            Core.players.get(p.getUniqueId()).setScoreboardVisibility(true);
                            setScoreBoard(p);
                            return true;
                        }
                        click.getEvent().getWhoClicked().sendMessage(ChatColor.RED + "");
                        return true;
                    }
                    return false;
                },
                ChatColor.RED + "Scoreboard Visibility",
                ChatColor.RED + "Toggle your scoreboard visibility"));
        gui.show(p);
    }

    //WILL FIX LATER
    public void setScoreBoard(Player player) {
        if(!Core.players.get(player.getUniqueId()).isScoreboardVisibility()) {
            return;
        }
        final CScoreboard scoreboard = new CScoreboard("Stormfront", "d", ChatColor.RED + "Stormfront");
        scoreboard.addRow(ChatColor.RED + "Name ➤");
        final CScoreboard.Row row = scoreboard.addRow("0");
        scoreboard.addRow(ChatColor.RED + "Level ➤");
        final CScoreboard.Row row2 = scoreboard.addRow("1");
        scoreboard.addRow(ChatColor.RED + "Exp ➤");
        final CScoreboard.Row row3 = scoreboard.addRow("2");
        scoreboard.addRow(ChatColor.RED + "Money ➤");
        final CScoreboard.Row row4 = scoreboard.addRow("3");
        scoreboard.finish();
        scoreboard.display(player);
        new BukkitRunnable() {
            public void run() {
                if (player.isOnline()) {
                    scoreboard.setTitle(ChatColor.RED + "Stormfront");
                    row.setMessage(player.getName());
                    row2.setMessage(Core.players.get(player.getUniqueId()).getLevel() + "");
                    row3.setMessage(Core.players.get(player.getUniqueId()).getExp() + "/" + Core.players.get(player.getUniqueId()).getExpToLevel());
                    row4.setMessage(Core.players.get(player.getUniqueId()).getMoney() + "");
                    return;
                }
                this.cancel();
            }
        }.runTaskTimer(Core.getPlugin(Core.class), 20, 20);
    }
}