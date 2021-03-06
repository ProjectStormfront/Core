package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportCommand extends CommandHandler {
    public TeleportCommand() {
        super("tp", "staff.tp", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length > 2 || args.length < 1) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(args.length == 1) {
            if(Bukkit.getPlayer(args[0]) == null) {
                p.sendMessage(ChatColor.RED + "Player is not online.");
                return;
            }
            Player target = Bukkit.getPlayer(args[0]);
            p.teleportAsync(target.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
            return;
        }
        if(args.length == 2) {
            if(Bukkit.getPlayer(args[0]) == null || Bukkit.getPlayer(args[1]) == null) {
                p.sendMessage(ChatColor.RED + "Player is not online.");
                return;
            }
            Player target = Bukkit.getPlayer(args[0]);
            Player otherTarget = Bukkit.getPlayer(args[1]);
            target.teleportAsync(otherTarget.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
        }
    }
}
