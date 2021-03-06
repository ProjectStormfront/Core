package core.deagan.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BaseEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public boolean call() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bukkit.getPluginManager().callEvent(new BaseEvent());
            }
        }).start();
        return true;
    }

}