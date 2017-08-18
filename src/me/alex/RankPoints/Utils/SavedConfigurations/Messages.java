package me.alex.RankPoints.Utils.SavedConfigurations;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

public enum Messages{
    // Declare all the messages
    NO_PERMISSION("permission"),
    BAD_SYNTAX("bad-syntax"),
    PREFIX("prefix"),
    NOT_PLAYER("not-player"),
    HELP("help")
    ;


    private  String text;

    Messages(String text) {
        this.text = text;
    }

    public String toMessageString()
    {
        return text;
    }

    public void send(CommandSender sender)
    {
        if(text == null)
        {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lThere has been an error sending the message &e&l" + this ));

            return;
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', text));


    }

    public void set(String msg)
    {
        text = msg;
    }


}