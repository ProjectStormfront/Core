package core.deagan.core.events;

import core.deagan.core.Core;
import core.deagan.core.managers.StaffManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandSpyListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onStaffMessage(PlayerCommandPreprocessEvent e) {
        Core.staff.forEach((uuid, staffManager) -> {
            if(staffManager.isCommandSpy()) {
                staffManager.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "[COMMAND] " + ChatColor.GRAY + e.getPlayer().getName() + " > " + e.getMessage()));
            }
        });
    }
}
