package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand extends CommandHandler {
    public BroadcastCommand() {
        super("broadcast", "staff.broadcast", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        StringBuilder messagebuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            messagebuilder.append(args[i]).append(" ");
        }
        String commandMessage = messagebuilder.toString();
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(ChatColor.BLACK + "[" + ChatColor.RED + "Broadcast" + ChatColor.BLACK + "] " + ChatColor.WHITE + commandMessage);
        });
    }
}
