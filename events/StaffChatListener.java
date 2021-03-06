package core.deagan.core.events;

import core.deagan.core.Core;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChatListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onStaffMessage(AsyncPlayerChatEvent e) {
        if(!Core.staff.get(e.getPlayer().getUniqueId()).isStaffChat()) {
            return;
        }
        e.setCancelled(true);
        LuckPerms api = LuckPermsProvider.get();
        Core.staff.forEach((uuid, staffManager) -> {
            staffManager.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "[STAFF] " + api.getPlayerAdapter(Player.class).getMetaData(e.getPlayer()).getPrefix() + e.getPlayer().getName() + ChatColor.RESET + ": " + e.getMessage()));
        });
    }
}
