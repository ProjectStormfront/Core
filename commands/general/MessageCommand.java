package core.deagan.core.commands.general;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand extends CommandHandler {
    public MessageCommand() {
        super("msg", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length < 2) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(Bukkit.getPlayer(args[0]) == null) {
            p.sendMessage(ChatColor.RED + "Player is not online.");
            return;
        }
        if(Bukkit.getPlayer(args[0]).getName().equalsIgnoreCase(p.getName())) {
            p.sendMessage(ChatColor.RED + "You can not message your self.");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            builder.append(args[i]).append(" ");
        }
        String message = builder.toString();
        target.sendMessage(ChatColor.GRAY + "(" + "from " + p.getName() + ": " + ChatColor.WHITE + message + ChatColor.GRAY + ")");
        p.sendMessage(ChatColor.GRAY + "(" + "to " + target.getName() + ": " + ChatColor.WHITE + message + ChatColor.GRAY + ")");
        Core.players.get(target.getUniqueId()).setLastMessage(p.getUniqueId());
        Core.players.get(p.getUniqueId()).setLastMessage(target.getUniqueId());
    }
}
