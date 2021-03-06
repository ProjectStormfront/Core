package core.deagan.core.commands.staff;

import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand extends CommandHandler {
    public SetSpawnCommand() {
        super("setspawn", "staff.setspawn", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        try {
            Core.getPlugin(Core.class).getConfig().set("Spawn.World", p.getWorld().getName());
            Core.getPlugin(Core.class).getConfig().set("Spawn.X", p.getLocation().getBlockX());
            Core.getPlugin(Core.class).getConfig().set("Spawn.Y", p.getLocation().getBlockY());
            Core.getPlugin(Core.class).getConfig().set("Spawn.Z", p.getLocation().getBlockZ());
            Core.getPlugin(Core.class).getConfig().set("Spawn.Yaw", p.getLocation().getYaw());
            Core.getPlugin(Core.class).getConfig().set("Spawn.Pitch", p.getLocation().getPitch());
            Core.getPlugin(Core.class).saveConfig();
            p.sendMessage(ChatColor.GREEN + "Spawn has been set.");
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "Something went wrong trying to set the spawn.");
            e.printStackTrace();
        }
    }
}
