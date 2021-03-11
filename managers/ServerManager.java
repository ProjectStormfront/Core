package core.deagan.core.managers;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServerManager {
    private String motd;
    public ServerManager(String motd) {
        this.motd = motd;
    }
}
