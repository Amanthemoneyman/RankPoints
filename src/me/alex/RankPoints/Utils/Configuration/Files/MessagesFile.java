package me.alex.RankPoints.Utils.Configuration.Files;

import me.alex.RankPoints.RankPoints;
import me.alex.RankPoints.Utils.Configuration.PluginFile;
import me.alex.RankPoints.Utils.SavedConfigurations.Messages;

public class MessagesFile extends PluginFile {
    public MessagesFile(String fileName, RankPoints plugin) {
        super(fileName, plugin);
        this.loadMessages();
    }

    public void loadMessages()
    {
        Messages.BAD_SYNTAX.set(this.getConfig().getString("Messages.BadSyntax"));
        Messages.NO_PERMISSION.set(this.getConfig().getString("Messages.NoPermission"));
        Messages.PREFIX.set(this.getConfig().getString("Messages.Prefix"));

        System.out.println("[RankPoints] Messages.yml loaded successfully");


    }
}
