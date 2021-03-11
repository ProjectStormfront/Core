package core.deagan.core.commands.staff.gamemode;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeAdventureCommand extends CommandHandler {
    public GamemodeAdventureCommand() {
        super("gma", "staff.gamemode", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length > 1) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(args.length == 0) {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(ChatColor.GREEN + "You are now in adventure.");
            return;
        }
        if(Bukkit.getPlayer(args[0]) == null) {
            p.sendMessage(ChatColor.RED + "Player is not online.");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        target.setGameMode(GameMode.ADVENTURE);
        p.sendMessage(ChatColor.GREEN + "They are now in adventure.");
    }
}
