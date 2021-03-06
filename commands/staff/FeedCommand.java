package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand extends CommandHandler {
    public FeedCommand() {
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
            p.setFoodLevel(20);
            p.sendMessage(ChatColor.GREEN + "You have been fed.");
            return;
        }
        if(args.length == 2) {
            if(Bukkit.getPlayer(args[0]) == null) {
                p.sendMessage(ChatColor.RED + "Player not online.");
                return;
            }
            Player target = Bukkit.getPlayer(args[0]);
            target.setFoodLevel(20);
            p.sendMessage(ChatColor.GREEN + "The person has been fed.");
        }
    }
}
