package core.deagan.core.commands.staff;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import core.deagan.core.Core;
import core.deagan.core.commands.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BanCommand extends CommandHandler {
    public BanCommand() {
        super("ban", "staff.ban", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Invalid Arguments.");
            return;
        }
        if(Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage(ChatColor.RED + "Player not online.");
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        StringBuilder reasonBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            reasonBuilder.append(args[i]).append(" ");
        }
        String reasonMessage = reasonBuilder.toString();
        if(target.getScoreboard() != null) {
            target.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }
        target.banPlayer(reasonMessage, null, null, true);

        if(Core.getPlugin(Core.class).getConfig().getBoolean("Server.ModerationWebhook")) {
            new Thread(() -> {
                WebhookClient client = WebhookClient.withUrl("https://discord.com/api/webhooks/818022988053741630/k5Z4DrJ6UVXM1I951eQLks5W103NC-OFzftZ7SZLrqvBbQw4JE3KWUFzq6GyIyERAsnn");
                WebhookEmbed embed = new WebhookEmbedBuilder()
                        .setColor(0xFF00EE)
                        .setDescription("**" + sender.getName() + "**" + " has banned " + "**" + target.getName() + "**" + "\n" + "**Reason: ** " + reasonMessage)
                        .setThumbnailUrl(String.format("https://crafatar.com/avatars/%s?overlay", target.getUniqueId().toString()))
                        .build();
                client.send(embed);
            }).start();
        }

    }
}
