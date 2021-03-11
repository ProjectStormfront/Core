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
    private boolean isCommandSpy;
    private boolean isMessageSpy;
    private boolean isBreakBlocks;
    public StaffManager(Player player, boolean isStaffChat, boolean isCommandSpy, boolean isMessageSpy, boolean isBreakBlocks) {
        this.player = player;
        this.isStaffChat = isStaffChat;
        this.isCommandSpy = isCommandSpy;
        this.isMessageSpy = isMessageSpy;
        this.isBreakBlocks = isBreakBlocks;
    }
}
