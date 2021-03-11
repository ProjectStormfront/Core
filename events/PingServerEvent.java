package core.deagan.core.events;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import core.deagan.core.Core;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;

public class PingServerEvent implements Listener {
    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        e.setMotd(
                ChatColor.translateAlternateColorCodes('&', Core.server.get(1).getMotd())
        );
    }
}
