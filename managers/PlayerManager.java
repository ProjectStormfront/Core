package core.deagan.core.managers;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
@Getter
@Setter
public class PlayerManager {
    private int level;
    private double exp;
    private int expToLevel;
    private int money;
    private Player player;
    public PlayerManager(Player player, int level, double exp, int expToLevel, int money) {
        this.player = player;
        this.level = level;
        this.exp = exp;
        this.expToLevel = expToLevel;
        this.money = money;
    }
}
