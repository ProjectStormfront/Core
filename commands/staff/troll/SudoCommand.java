package core.deagan.core.commands.staff.troll;

import core.deagan.core.commands.CommandHandler;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SudoCommand extends CommandHandler {
    LuckPerms api = LuckPermsProvider.get();
    public SudoCommand() {
        super("sudo", "staff.sudo", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length < 3) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        switch (args[0]) {
            case "chat":
                if(Bukkit.getPlayer(args[1]) == null) {
                    p.sendMessage(ChatColor.RED + "Player not online.");
                    return;
                }
                Player messageTarget = Bukkit.getPlayer(args[1]);
                StringBuilder builder = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    builder.append(args[i]).append(" ");
                }
                String message = builder.toString();
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', api.getPlayerAdapter(Player.class).getMetaData(messageTarget).getPrefix() + messageTarget.getName() + ": " + message));
                });
                p.sendMessage(ChatColor.GREEN + "They have said your message in chat.");
                break;
            case "command":
                if(Bukkit.getPlayer(args[1]) == null) {
                    p.sendMessage(ChatColor.RED + "Player not online.");
                    return;
                }
                Player commandTarget = Bukkit.getPlayer(args[1]);
                StringBuilder commandbuilder = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    commandbuilder.append(args[i]).append(" ");
                }
                String commandMessage = commandbuilder.toString();
                commandTarget.performCommand(commandMessage);
                p.sendMessage(ChatColor.GREEN + "They have performed the command.");
                break;
            default:
                p.sendMessage(ChatColor.RED + "Invalid Option. (chat/command)");
        }
    }
}
