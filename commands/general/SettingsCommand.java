package core.deagan.core.commands.general;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import core.deagan.core.inventories.SettingsInventory;
import core.deagan.core.utils.ItemBuilder;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SettingsCommand extends CommandHandler {

    SettingsInventory settingsInventory = new SettingsInventory();

    String[] guiSetup = {
            "    s    ",
    };

    public SettingsCommand() {
        super("settings", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        InventoryGui gui = new InventoryGui(Core.getPlugin(Core.class), p, ChatColor.RED + "Settings", guiSetup);
        settingsInventory.openSettingsInventory(gui, p);
    }
}
