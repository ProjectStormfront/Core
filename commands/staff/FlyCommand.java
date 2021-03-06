package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand extends CommandHandler {
    public FlyCommand() {
        super("fly", "staff.fly", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player)sender;
        if(args.length == 0) {
            if(p.isFlying()) {
                p.setFlying(false);
                p.setAllowFlight(false);
                p.sendMessage(ChatColor.RED + "You are no longer flying.");
                return;
            }
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(ChatColor.GREEN + "You are now flying.");
            return;
        }
        if(args.length == 1) {
            if(Bukkit.getPlayer(args[1]) == null) {
                p.sendMessage(ChatColor.RED + "Player is not online.");
                return;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(target.isFlying()) {
                target.setFlying(false);
                target.setAllowFlight(false);
                target.sendMessage(ChatColor.RED + "Staff has taken away your flight.");
                return;
            }
            target.setAllowFlight(true);
            target.setFlying(true);
            target.sendMessage(ChatColor.GREEN + "Staff has given you flight.");
        }
    }
}
