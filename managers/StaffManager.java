package core.deagan.core.managers;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
@Setter
public class StaffManager {
    private Player player;
    private boolean isStaffChat;
    public StaffManager(Player player, boolean isStaffChat) {
        this.player = player;
        this.isStaffChat = isStaffChat;
    }
}
