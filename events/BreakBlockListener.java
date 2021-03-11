package core.deagan.core.events;

import core.deagan.core.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlockListener implements Listener {
    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if(!e.getPlayer().hasPermission("staff.breakblocks")) e.setCancelled(true);
        if(!Core.staff.get(e.getPlayer().getUniqueId()).isBreakBlocks()) e.setCancelled(true);
        return;
    }
}
