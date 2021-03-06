package core.deagan.core.commands.chat;

import core.deagan.core.Core;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;

public class ChatFormatting implements @NotNull Listener {
    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent e) {
        LuckPerms api = LuckPermsProvider.get();
        ChatAttempt chatAttempt = Core.getPlugin(Core.class).getChat().attemptChatMessage(e.getPlayer(), e.getMessage());
        ChatAttemptEvent chatAttemptEvent = new ChatAttemptEvent(e.getPlayer(), chatAttempt, e.getMessage());
        if(!chatAttemptEvent.isCancelled()) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', api.getPlayerAdapter(Player.class).getMetaData(e.getPlayer()).getPrefix()) + "%1$s" + ChatColor.RESET + ": %2$s");
        }
    }
}
