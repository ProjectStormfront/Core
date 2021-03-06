package core.deagan.core.commands.general;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand extends CommandHandler {
    public HelpCommand() {
        super("help", "", false);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(
                ChatColor.translateAlternateColorCodes('&', "&c&m-------------------") + "\n" +
                        ChatColor.RED + "/vanish - " + ChatColor.GRAY + "Vanishes you from all players." + "\n" +
                        ChatColor.RED + "/tp - " + ChatColor.GRAY + "Teleports you to another player" + "\n" +
                        ChatColor.RED + "/sc - " + ChatColor.GRAY + "Toggles staff chat." + "\n" +
                        ChatColor.RED + "/fly - " + ChatColor.GRAY + "Toggles flight." + "\n" +
                        ChatColor.RED + "/speed - " + ChatColor.GRAY + "Changes your walk/flight speed." + "\n" +
                        ChatColor.translateAlternateColorCodes('&', "&c&m-------------------")
        );
    }
}
