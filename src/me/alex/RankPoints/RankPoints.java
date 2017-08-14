package me.alex.RankPoints;

import me.alex.RankPoints.Listeners.RPOnKill;
import me.alex.RankPoints.Utils.Configuration.FileManager;
import me.alex.RankPoints.Utils.Configuration.Files.MessagesFile;
import me.alex.RankPoints.Utils.SavedConfigurations.ConfigOptions;
import me.alex.RankPoints.Utils.SavedConfigurations.ConfigValues;
import me.alex.RankPoints.Utils.SavedConfigurations.Messages;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class RankPoints extends JavaPlugin {

    Permission perms;

    public void onEnable()
    {
        saveDefaultConfig();
        if(setupPermissions())
        {


        } else
        {
             Bukkit.getPluginManager().disablePlugin(this);
        }

        Messages.NO_PERMISSION.send(Bukkit.getConsoleSender());



    }

    public void onDisable()
    {



    }

    public RPOnKill rponkill;
    public FileManager fm;
    public MessagesFile mf;

    public MessagesFile getMessageFile() {
        return mf;
    }

    public FileManager getFileManager() {
        return fm;
    }

    private void loadClasses()
    {
        rponkill = new RPOnKill(this);
        fm = new FileManager(this);
        mf = new MessagesFile("messages.yml", this);



    }


    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}
