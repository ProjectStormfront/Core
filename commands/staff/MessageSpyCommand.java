package core.deagan.core.commands.staff;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageSpyCommand extends CommandHandler {
    public MessageSpyCommand() {
        super("msgspy", "staff.msgspy", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(Core.staff.get(p.getUniqueId()).isMessageSpy()) {
            Core.staff.get(p.getUniqueId()).setMessageSpy(false);
            p.sendMessage(ChatColor.RED + "You disabled message spy.");
            return;
        }
        Core.staff.get(p.getUniqueId()).setMessageSpy(true);
        p.sendMessage(ChatColor.GREEN + "You enabled message spy.");
    }
}
