package core.deagan.core.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatAttempt {

    private Response response;
    private Object value;

    public ChatAttempt(Response response) {
        this.response = response;
    }

    public enum Response {
        ALLOWED,
        MESSAGE_FILTERED,
        PLAYER_MUTED,
        CHAT_MUTED,
        CHAT_DELAYED
    }

}
