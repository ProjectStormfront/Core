package core.deagan.core.commands.general;

import com.google.gson.Gson;
import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NameMCCommand extends CommandHandler {
    public NameMCCommand() {
        super("namemc", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0) {
            p.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        new Thread(() -> {
            try {
                URL serverLikes = new URL(String.format("https://api.namemc.com/server/%s/likes", Core.getPlugin(Core.class).getConfig().getString("NameMC.Address")));
                URLConnection namemcConnection = serverLikes.openConnection();
                namemcConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                namemcConnection.getDoOutput();
                try(final BufferedReader reader = new BufferedReader(new InputStreamReader(namemcConnection.getInputStream()))) {
                    String[] likes = new Gson().fromJson(reader, String[].class);
                    for (String like : likes) {
                        if(like.contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.GREEN + "You have liked.");
                           return;
                        }
                    }
                    p.sendMessage(ChatColor.RED + "You did not like.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
