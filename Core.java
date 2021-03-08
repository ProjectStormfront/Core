package core.deagan.core;

import core.deagan.core.commands.CommandHandler;
import core.deagan.core.chat.Chat;
import core.deagan.core.chat.ChatFormatting;
import core.deagan.core.events.*;
import core.deagan.core.events.leveling.MobKillEvent;
import core.deagan.core.managers.PlayerManager;
import core.deagan.core.managers.StaffManager;
import lombok.Getter;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public final class Core extends JavaPlugin {
    private static Core plugin;
    public static ConcurrentHashMap<UUID, StaffManager> staff = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<UUID, PlayerManager> players = new ConcurrentHashMap<>();
    private Chat chat;
    private File playerFile;
    private FileConfiguration playerConfig;
    @Override
    public void onEnable() {
        plugin = this;
        new GrantListener(this, LuckPermsProvider.get());
        createCustomConfig();
        chat = new Chat(this);
        CommandHandler.registerCommands(this);
        Bukkit.getPluginManager().registerEvents(new ChatFormatting(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new StaffChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PingServerEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeave(), this);
        Bukkit.getPluginManager().registerEvents(new MobKillEvent(), this);
        Bukkit.getLogger().info("Deagan's Core Loaded");
    }
    @Override
    public void onDisable() {
        players.forEach((uuid, playerManager) -> {
            getCustomConfig().set(uuid + ".Level", playerManager.getLevel());
            getCustomConfig().set(uuid + ".Exp", playerManager.getExp());
            getCustomConfig().set(uuid + ".ExpToLevel", playerManager.getExpToLevel());
            getCustomConfig().set(uuid + ".Money", playerManager.getMoney());
        });
        try {
            getCustomConfig().save(new File(getDataFolder(), "playerdata.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        plugin = null;
        Bukkit.getLogger().info("Deagan's Core Unloaded");
    }

    private void createCustomConfig() {
        playerFile = new File(getDataFolder(), "playerdata.yml");
        if (!playerFile.exists()) {
            playerFile.getParentFile().mkdirs();
            saveResource("playerdata.yml", false);
        }

        playerConfig = new YamlConfiguration();
        try {
            playerConfig.load(playerFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getCustomConfig() {
        return this.playerConfig;
    }

}
