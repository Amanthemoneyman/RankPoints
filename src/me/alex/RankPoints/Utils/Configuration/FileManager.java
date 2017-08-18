package me.alex.RankPoints.Utils.Configuration;


import me.alex.RankPoints.RankPoints;
import me.alex.RankPoints.Utils.Configuration.Files.MessagesFile;
import me.alex.RankPoints.Utils.Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 7/15/2017.
 */
public class FileManager {

    private RankPoints plugin;
    private ArrayList<PluginFile> files;

    public FileManager(RankPoints plugin) {
        this.plugin = plugin;
        files = new ArrayList<PluginFile>();

        Utilities.debug("Amount of files in RankPoints : " + plugin.getDataFolder().listFiles().length);

        if(!plugin.getDataFolder().exists())
        {
            plugin.getDataFolder().mkdir();

return;
        }

        if(plugin.getDataFolder().listFiles().length < 2)
        {
            if()
            for(File f : plugin.getDataFolder().listFiles())
            {
                if(f.getName().equalsIgnoreCase("config.yml"))
                {
                    plugin.mf = new MessagesFile("messages.yml", plugin);

                } else if(f.getName().equalsIgnoreCase("messages.yml"))
                {
                    plugin.cf = new PluginFile("config.yml", plugin);
                    this.files.add(plugin.cf);
                    Utilities.debug("cf instance created in constructor FileManager, only " + plugin.getDataFolder().listFiles().length + " file(s) were present");

                }

            }

        }
        Utilities.debug("Loading server files");
        loadFiles();



    }

    public void loadFiles() {

        File[] files = plugin.getDataFolder().listFiles();

        for(File f: files)
        {

            if(f == null)
            {
                Utilities.debug("File " + f.getName() + " Is null");
            }
            if(plugin == null)
            {

                Utilities.debug("Plugin is null");

            }
            if(!this.isFile(f.getName()))
            {
                if(f.getName().equalsIgnoreCase("messages.yml"))
                {
                    MessagesFile mf = new MessagesFile(f, plugin);
                    this.files.add(mf);

                    return;
                }
                PluginFile pf = new PluginFile(f, plugin);
                this.files.add(pf);

            }


        }


    }

    public ArrayList<PluginFile> getFiles()
    {
        return this.files;
    }

    public File getFile(String name) {
        for (File f : files) {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }

        }
        return null;
    }

    public PluginFile getPluginFile(String name)
    {
        for(PluginFile f : files)
        {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }


        }
        return null;


    }

    public boolean isFile(String name)
    {
        for(PluginFile f : getFiles())
        {
            if(f.getName().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false;

    }

    public boolean isFile(PluginFile pf)
    {
        if(getFiles().contains(pf)) return true;
        return false;


    }

    public FileManager addFile(PluginFile pf)
    {
        if(isFile(pf))
        {
            return this;
        }
        files.add(pf);
        return this;


    }
}
