package core.deagan.core.events;

import core.deagan.core.Core;
import core.deagan.core.managers.StaffManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(e.getPlayer().isOp()) {
            Core.staff.put(e.getPlayer().getUniqueId(), new StaffManager(e.getPlayer(), false));
            return;
        }
    }
}
