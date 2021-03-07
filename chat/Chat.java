package core.deagan.core.chat;

import core.deagan.core.Core;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class Chat {
    private final Core core;
    public Chat(Core core) {
        this.core = core;
    }
    public ChatAttempt attemptChatMessage(Player player, String message) {
        String msg = message.toLowerCase()
                .replace("3", "e")
                .replace("1", "i")
                .replace("!", "i")
                .replace("@", "a")
                .replace("7", "t")
                .replace("0", "o")
                .replace("5", "s")
                .replace("8", "b")
                .replaceAll("\\p{Punct}|\\d", "").trim();
        String[] words = msg.trim().split(" ");
        return new ChatAttempt(ChatAttempt.Response.ALLOWED);
    }
}

