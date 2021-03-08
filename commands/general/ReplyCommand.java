package core.deagan.core.commands.general;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand extends CommandHandler {
    public ReplyCommand() {
        super("r", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length < 1) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(Bukkit.getPlayer(Core.players.get(p.getUniqueId()).getLastMessage()) == null) {
            p.sendMessage(ChatColor.RED + "Player is not online.");
            return;
        }
        Player target = Bukkit.getPlayer(Core.players.get(p.getUniqueId()).getLastMessage());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]).append(" ");
        }
        String message = builder.toString();
        target.sendMessage(ChatColor.GRAY + "(" + "from " + p.getName() + ": " + ChatColor.WHITE + message + ChatColor.GRAY + ")");
        p.sendMessage(ChatColor.GRAY + "(" + "to " + target.getName() + ": " + ChatColor.WHITE + message + ChatColor.GRAY + ")");
    }
}
