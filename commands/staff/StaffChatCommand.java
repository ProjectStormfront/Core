package core.deagan.core.commands.staff;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import core.deagan.core.managers.StaffManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand extends CommandHandler {
    public StaffChatCommand() {
        super("sc", "staff.sc", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(Core.staff.get(p.getUniqueId()).isStaffChat()) {
            Core.staff.get(p.getUniqueId()).setStaffChat(false);
            p.sendMessage(ChatColor.RED + "You disabled staff chat.");
            return;
        }
        Core.staff.get(p.getUniqueId()).setStaffChat(true);
        p.sendMessage(ChatColor.GREEN + "You enabled staff chat.");
    }
}
