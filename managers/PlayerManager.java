package core.deagan.core.managers;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public class PlayerManager {
    private int level;
    private double exp;
    private int expToLevel;
    private int money;
    private Player player;
    private UUID lastMessage;
    public PlayerManager(Player player, int level, double exp, int expToLevel, int money, UUID lastMessage) {
        this.player = player;
        this.lastMessage = lastMessage;
        this.level = level;
        this.exp = exp;
        this.expToLevel = expToLevel;
        this.money = money;
    }
}
