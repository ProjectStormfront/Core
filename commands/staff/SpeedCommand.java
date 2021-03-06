package core.deagan.core.commands.staff;

import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand extends CommandHandler {
    public SpeedCommand() {
        super("speed", "staff.speed", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player)sender;
        if(p.isFlying() && !p.isOnGround()) {
            try {
                p.setFlySpeed(Float.parseFloat(args[0]));
                p.sendMessage(ChatColor.GREEN + "Your flight speed has been changed.");
                return;
            } catch (NumberFormatException e) {
                p.sendMessage("Values are 0.1 - 1.0");
            }
        }
        if(!p.isFlying() && p.isOnGround()) {
            try {
                p.setWalkSpeed(Float.parseFloat(args[0]));
                p.sendMessage(ChatColor.GREEN + "Your walk speed has been changed.");
            } catch (NumberFormatException e) {
                p.sendMessage("Values are 0.1 - 1.0");
            }
        }
    }
}
