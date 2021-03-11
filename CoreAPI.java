package core.deagan.core;

import org.bukkit.entity.Player;

public class CoreAPI {
    public static int getLevel(Player player) {
        return Core.getPlugin(Core.class).getCustomConfig().getInt(player.getUniqueId().toString() + ".Level");
    }
    public static double getExp(Player player) {
        return Core.getPlugin(Core.class).getCustomConfig().getDouble(player.getUniqueId().toString() + ".Exp");
    }
    public static void setLevel(Player player, int level) {
        Core.getPlugin(Core.class).getCustomConfig().set(player.getUniqueId().toString() + ".Level", level);
    }
    public static void setExp(Player player, int exp) {
        Core.getPlugin(Core.class).getCustomConfig().set(player.getUniqueId().toString() + ".Exp", exp);
    }
    public static int getMoney(Player player) {
        return Core.getPlugin(Core.class).getCustomConfig().getInt(player.getUniqueId().toString() + ".Money");
    }
    public static void setMoney(Player player, int money) {
        Core.getPlugin(Core.class).getCustomConfig().set(player.getUniqueId().toString() + ".Money", money);
    }

}
