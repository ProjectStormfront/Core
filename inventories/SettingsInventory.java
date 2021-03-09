package core.deagan.core.inventories;

import core.deagan.core.Core;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
}