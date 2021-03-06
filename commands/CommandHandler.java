package core.deagan.core.commands;

import core.deagan.core.Core;
import core.deagan.core.commands.general.HelpCommand;
import core.deagan.core.commands.staff.*;
import core.deagan.core.commands.staff.troll.RotateHeadCommand;
import core.deagan.core.commands.staff.troll.SudoCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CommandHandler implements CommandExecutor {
    private final String commandName;
    private final String permission;
    private final boolean canConsoleUse;

    public CommandHandler(String commandName, String permission, boolean canConsoleUse) {
        this.commandName = commandName;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        Core.getPlugin(Core.class).getCommand(commandName).setExecutor(this);
    }

    public abstract void execute(CommandSender sender, String[] args);

    public static JavaPlugin plugin;

    public final static void registerCommands(JavaPlugin pl){
        plugin = pl;
        new HelpCommand();
        new VanishCommand();
        new TeleportCommand();
        new StaffChatCommand();
        new FlyCommand();
        new SpeedCommand();
        new HealCommand();
        new FeedCommand();
        new RotateHeadCommand();
        new SudoCommand();
        //
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(!cmd.getLabel().equalsIgnoreCase(commandName))
            return true;
        if(!sender.hasPermission(permission)){
            sender.sendMessage(ChatColor.RED + "You don't have permission for this.");
            return true;
        }
        if(!canConsoleUse && !(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Only players may use this command sorry!");
            return true;
        }
        execute(sender, args);
        return true;
    }

}
