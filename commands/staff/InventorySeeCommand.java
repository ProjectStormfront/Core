package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventorySeeCommand extends CommandHandler {
    public InventorySeeCommand() {
        super("invsee", "staff.invsee", false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 1) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(Bukkit.getPlayer(args[0]) == null) {
            p.sendMessage(ChatColor.RED + "Player is not online.");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        p.openInventory(target.getInventory());
    }
}
