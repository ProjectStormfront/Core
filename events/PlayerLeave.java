package core.deagan.core.events;

import core.deagan.core.Core;
import core.deagan.core.managers.PlayerManager;
import core.deagan.core.managers.StaffManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class PlayerLeave implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) throws IOException {
        PlayerManager playerManager = Core.players.get(e.getPlayer().getUniqueId());
        try {
            if(e.getPlayer().hasPermission("staff.staff")) {
                StaffManager staffManager = Core.staff.get(e.getPlayer().getUniqueId());
                Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".StaffChat", staffManager.isStaffChat());
                Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".BreakBlocks", staffManager.isBreakBlocks());
                Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".MessageSpy", staffManager.isMessageSpy());
                Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".CommandSpy", staffManager.isCommandSpy());
                Core.getPlugin(Core.class).getCustomConfig().save(new File(Core.getPlugin(Core.class).getDataFolder(), "playerdata.yml"));
                Core.staff.remove(e.getPlayer().getUniqueId());
            }
            Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".Level", playerManager.getLevel());
            Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".Exp", playerManager.getExp());
            Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".ExpToLevel", playerManager.getExpToLevel());
            Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".Money", playerManager.getMoney());
            Core.getPlugin(Core.class).getCustomConfig().set(e.getPlayer().getUniqueId() + ".ScoreboardVisibility", playerManager.isScoreboardVisibility());
            Core.getPlugin(Core.class).getCustomConfig().save(new File(Core.getPlugin(Core.class).getDataFolder(), "playerdata.yml"));
        } catch (NullPointerException ignore) {}
        Core.players.remove(e.getPlayer().getUniqueId());
        e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }
}
