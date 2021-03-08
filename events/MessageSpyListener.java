package core.deagan.core.events;

import core.deagan.core.Core;
import core.deagan.core.managers.StaffManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class MessageSpyListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onStaffMessage(PlayerCommandPreprocessEvent e) {
        if(!e.getMessage().split(" ")[0].equalsIgnoreCase("/msg")) {
            return;
        }
        String[] premessage = e.getMessage().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < premessage.length; i++) {
            builder.append(premessage[i]).append(" ");
        }
        String message = builder.toString();
        Core.staff.forEach((uuid, staffManager) -> {
            if(staffManager.isMessageSpy()) {
                staffManager.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes
                        ('&',
                                ChatColor.RED + "[MESSAGE] " + ChatColor.GRAY + "(" + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GRAY + "->" + ChatColor.WHITE + Bukkit.getPlayer(Core.players.get(e.getPlayer().getUniqueId()).getLastMessage()).getName()) + ChatColor.GRAY + "): " + message);
            }
        });
    }
}
