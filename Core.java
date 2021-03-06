package core.deagan.core;

import core.deagan.core.commands.CommandHandler;
import core.deagan.core.commands.chat.Chat;
import core.deagan.core.commands.chat.ChatFormatting;
import core.deagan.core.events.PlayerJoin;
import core.deagan.core.events.StaffChatListener;
import core.deagan.core.managers.StaffManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public final class Core extends JavaPlugin {
    private static Core plugin;

    public static ConcurrentHashMap<UUID, StaffManager> staff = new ConcurrentHashMap<>();

    private Chat chat;
    @Override
    public void onEnable() {
        plugin = this;
        chat = new Chat(this);
        CommandHandler.registerCommands(this);
        Bukkit.getPluginManager().registerEvents(new ChatFormatting(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new StaffChatListener(), this);
        Bukkit.getLogger().info("Deagan's Core Loaded");
    }
    @Override
    public void onDisable() {
        plugin = null;
        Bukkit.getLogger().info("Deagan's Core Unloaded");
    }
}
