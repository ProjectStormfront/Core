package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand extends CommandHandler {
    public HealCommand() {
        super("feed", "staff.feed", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length < 1 || args.length > 1) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(args.length == 1) {
            p.setHealth(20);
            p.sendMessage(ChatColor.GREEN + "You have been healed.");
            return;
        }
        if(args.length == 2) {
            if(Bukkit.getPlayer(args[0]) == null) {
                p.sendMessage(ChatColor.RED + "Player not online.");
                return;
            }
            Player target = Bukkit.getPlayer(args[0]);
            target.setHealth(20);
            p.sendMessage(ChatColor.GREEN + "They have been healed.");
        }
    }
}
