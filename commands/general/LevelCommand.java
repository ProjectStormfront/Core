package core.deagan.core.commands.general;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import core.deagan.core.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand extends CommandHandler {
    public LevelCommand() {
        super("level", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        PlayerManager playerManager = Core.players.get(p.getUniqueId());
        sender.sendMessage(ChatColor.BLACK + "[" + ChatColor.RED + "Stats" + ChatColor.BLACK + "] " + ChatColor.RED + Core.players.get(p.getUniqueId()).getLevel() + "\nExp: " + playerManager.getExp() + "/" + playerManager.getExpToLevel());
    }
}
