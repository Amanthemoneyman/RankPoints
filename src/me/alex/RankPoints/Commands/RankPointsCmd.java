package me.alex.RankPoints.Commands;

import me.alex.RankPoints.Utils.SavedConfigurations.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by alexm on 8/17/2017.
 */
public class RankPointsCmd implements CommandExecutor {
    me.alex.RankPoints.RankPoints plugin;


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        if(commandSender instanceof  Player)
        {
            Player p = (Player) commandSender;
            if(cmd.getName().equalsIgnoreCase("rankpoints"))
            {
                if(hasPerm(commandSender, "rankpoints.use"))
                {
                    Messages.HELP.send(p);

                }


            }


        } else
        {
            Messages.NOT_PLAYER.send(commandSender);
        }

        return false;
    }

    private boolean hasPerm(CommandSender s, String perm)
    {
        if(s.isOp())
        {
            return true;
        }
        if(s.hasPermission("*"))
        {
            return true;
        }
        if(s.hasPermission(perm))
        {
            return true;
        }

        return false;
    }
}
