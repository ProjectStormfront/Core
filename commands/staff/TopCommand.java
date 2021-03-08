package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TopCommand extends CommandHandler {

    public TopCommand() {
        super("top", "staff.top", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        Location loc = p.getLocation();
        for(int i = 255; i > 1; i--){
            loc.setY(i);
            Block b = p.getWorld().getBlockAt(loc);
            if(!b.isEmpty()){
                p.teleport(loc.add(0, 1, 0));
                p.sendMessage(ChatColor.GREEN + "You have been teleported to the highest block.");
                break;
            }
        }
    }
}
