package core.deagan.core.events.leveling;

import core.deagan.core.Core;
import core.deagan.core.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobKillEvent implements Listener {
    @EventHandler
    public void onMobKill(EntityDeathEvent e) {
        if (e.getEntity() instanceof Player) return;
        PlayerManager playerManager = Core.players.get(e.getEntity().getKiller().getUniqueId());
        if (e.getEntity().getCustomName().equalsIgnoreCase(ChatColor.RED + "Goblin")) {
            playerManager.setExp(playerManager.getExp() + 1);
            playerManager.setMoney(playerManager.getMoney() + 1);
            if (playerManager.getExp() >= playerManager.getExpToLevel()) {
                playerManager.getPlayer().sendMessage(ChatColor.GREEN + "You have leveled up! you are now level " + playerManager.getLevel());
                playerManager.setExp(playerManager.getExp() - playerManager.getExpToLevel());
                playerManager.setLevel(playerManager.getLevel() + 1);
                return;
            }
        }
        if (e.getEntity().getCustomName().equalsIgnoreCase(ChatColor.RED + "Angry Chicken")) {
            playerManager.setExp(playerManager.getExp() + 1);
            playerManager.setMoney(playerManager.getMoney() + 1);
            if (playerManager.getExp() >= playerManager.getExpToLevel()) {
                playerManager.getPlayer().sendMessage(ChatColor.GREEN + "You have leveled up! you are now level " + playerManager.getLevel());
                playerManager.setExp(playerManager.getExp() - playerManager.getExpToLevel());
                playerManager.setLevel(playerManager.getLevel() + 1);
                return;
            }
        }
    }
}
