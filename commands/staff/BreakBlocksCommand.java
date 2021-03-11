package core.deagan.core.commands.staff;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BreakBlocksCommand extends CommandHandler {
    public BreakBlocksCommand() {
        super("breakblocks", "staff.breakblocks", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(Core.staff.get(p.getUniqueId()).isBreakBlocks()) {
            Core.staff.get(p.getUniqueId()).setBreakBlocks(false);
            p.sendMessage(ChatColor.RED + "You can no longer break blocks.");
            return;
        }
        Core.staff.get(p.getUniqueId()).setBreakBlocks(true);
        p.sendMessage(ChatColor.GREEN + "You can now break blocks.");
    }
}
