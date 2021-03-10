package core.deagan.core.events;

import core.deagan.core.Core;
import core.deagan.core.CoreAPI;
import core.deagan.core.managers.PlayerManager;
import core.deagan.core.managers.StaffManager;
import core.deagan.core.utils.CScoreboard;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class PlayerJoin implements Listener {
    LuckPerms api = LuckPermsProvider.get();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(e.getPlayer().isBanned()) return;
        if(e.getPlayer().isOp()) {
            Core.staff.put(e.getPlayer().getUniqueId(), new StaffManager(e.getPlayer(), false, false, false));
        }
        e.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', api.getPlayerAdapter(Player.class).getMetaData(e.getPlayer()).getPrefix() + e.getPlayer().getName()));
        if(!Core.getPlugin(Core.class).getCustomConfig().contains(e.getPlayer().getUniqueId().toString())) {
            Core.players.put(e.getPlayer().getUniqueId(), new PlayerManager(e.getPlayer(), 1, 0, 10, 10, null, true));
            setScoreBoard(e.getPlayer());
            return;
        }
        try {
            Core.players.put(e.getPlayer().getUniqueId(), new PlayerManager(e.getPlayer(), Core.getPlugin(Core.class).getCustomConfig().getInt(e.getPlayer().getUniqueId().toString() + ".Level"), Core.getPlugin(Core.class).getCustomConfig().getDouble(e.getPlayer().getUniqueId().toString() + ".Exp"), Core.getPlugin(Core.class).getCustomConfig().getInt(e.getPlayer().getUniqueId().toString() + ".ExpToLevel"), Core.getPlugin(Core.class).getCustomConfig().getInt(e.getPlayer().getUniqueId().toString() + ".Money"), null, Core.getPlugin(Core.class).getCustomConfig().getBoolean(e.getPlayer().getUniqueId().toString() + ".ScoreboardVisibility")));
            setScoreBoard(e.getPlayer());
        } catch (NullPointerException ex) {
            Core.players.put(e.getPlayer().getUniqueId(), new PlayerManager(e.getPlayer(), 1, 0, 10, 10, null, true));
            setScoreBoard(e.getPlayer());
        }
        setScoreBoard(e.getPlayer());
    }

    public void setScoreBoard(Player player) {
        if(!Core.players.get(player.getUniqueId()).isScoreboardVisibility()) {
            return;
        }
        final CScoreboard scoreboard = new CScoreboard("Stormfront", "d", ChatColor.RED + "Stormfront");
        scoreboard.addRow(ChatColor.RED + "Name ➤");
        final CScoreboard.Row row = scoreboard.addRow("0");
        scoreboard.addRow(ChatColor.RED + "Level ➤");
        final CScoreboard.Row row2 = scoreboard.addRow("1");
        scoreboard.addRow(ChatColor.RED + "Exp ➤");
        final CScoreboard.Row row3 = scoreboard.addRow("2");
        scoreboard.addRow(ChatColor.RED + "Money ➤");
        final CScoreboard.Row row4 = scoreboard.addRow("3");
        scoreboard.finish();
        scoreboard.display(player);
        new BukkitRunnable() {
            public void run() {
                if (player.isOnline()) {
                    scoreboard.setTitle(ChatColor.RED + "Stormfront");
                    row.setMessage(player.getName());
                    row2.setMessage(Core.players.get(player.getUniqueId()).getLevel() + "");
                    row3.setMessage(Core.players.get(player.getUniqueId()).getExp() + "/" + Core.players.get(player.getUniqueId()).getExpToLevel());
                    row4.setMessage(Core.players.get(player.getUniqueId()).getMoney() + "");
                    return;
                }
                this.cancel();
            }
        }.runTaskTimer(Core.getPlugin(Core.class), 20, 20);
    }

}
