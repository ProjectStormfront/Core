package core.deagan.core.commands.staff;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import core.deagan.core.managers.StaffManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpyCommand extends CommandHandler {
    public CommandSpyCommand() {
        super("cmdspy", "staff.cmdspy", false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(Core.staff.get(p.getUniqueId()).isCommandSpy()) {
            Core.staff.get(p.getUniqueId()).setCommandSpy(false);
            p.sendMessage(ChatColor.RED + "You disabled command spy.");
            return;
        }
        Core.staff.get(p.getUniqueId()).setCommandSpy(true);
        p.sendMessage(ChatColor.GREEN + "You enabled command spy.");
    }
}
