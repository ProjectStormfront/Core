package core.deagan.core.commands.general;

import core.deagan.core.Core;
import core.deagan.core.CoreAPI;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class SpawnCommand extends CommandHandler {
    public SpawnCommand() {
        super("spawn", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        p.teleport(new Location(Bukkit.getWorld(Core.getPlugin(Core.class).getConfig().getString("Spawn.World"))
                , Core.getPlugin(Core.class).getConfig().getInt("Spawn.X")
                , Core.getPlugin(Core.class).getConfig().getInt("Spawn.y")
                , Core.getPlugin(Core.class).getConfig().getInt("Spawn.z")
                , (float)Core.getPlugin(Core.class).getConfig().getDouble("Spawn.Yaw")
                , (float)Core.getPlugin(Core.class).getConfig().getDouble("Spawn.Pitch")));
        p.sendMessage(ChatColor.GREEN + "You have been teleported to spawn.");
    }
}
