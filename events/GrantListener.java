package core.deagan.core.events;

import core.deagan.core.Core;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class GrantListener {
    private final Core plugin;

    public GrantListener(Core plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        EventBus eventBus = luckPerms.getEventBus();
        // 3. Subscribe to an event using a method reference
        eventBus.subscribe(this.plugin, UserDataRecalculateEvent.class, this::onUserDataRecalculate);
    }

    private void onUserDataRecalculate(UserDataRecalculateEvent event) {
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
            @Override
            public void run() {
                if(Bukkit.getPlayer(event.getUser().getUniqueId()) != null) {
                    Bukkit.getPlayer(event.getUser().getUniqueId()).setPlayerListName(ChatColor.translateAlternateColorCodes('&', event.getData().getMetaData().getPrefix() + Bukkit.getPlayer(event.getUser().getUniqueId()).getName()));
                    return;
                }
                return;
            }
        }, 2L);
    }
}