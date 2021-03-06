package core.deagan.core.commands.staff.troll;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class RotateHeadCommand extends CommandHandler {
    public RotateHeadCommand() {
        super("rotatehead", "staff.rotatehead", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 1) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(Bukkit.getPlayer(args[0]) == null) {
            p.sendMessage(ChatColor.RED + "Player not online.");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        target.getLocation().setYaw(target.getLocation().getYaw() + 180);
        p.sendMessage(ChatColor.GREEN + "You have rotated the head 180 degrees.");
    }
}
