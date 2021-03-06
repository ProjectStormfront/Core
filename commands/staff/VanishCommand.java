package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishCommand extends CommandHandler {
    public static Set<UUID> vanishedPlayers = new HashSet<>();
    public VanishCommand() {
        super("vanish", "staff.vanish", false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player)sender;
        if(vanishedPlayers.contains(p.getUniqueId())) {
            p.sendMessage(ChatColor.RED + "You are no longer vanished!");
            Bukkit.getOnlinePlayers().forEach(players -> {
                players.showPlayer(p);
            });
            vanishedPlayers.remove(p.getUniqueId());
            return;
        }
        Bukkit.getOnlinePlayers().forEach(players -> {
            players.hidePlayer(p);
        });
        vanishedPlayers.add(p.getUniqueId());
        p.sendMessage(ChatColor.GREEN + "You are now vanished!");
    }
}
