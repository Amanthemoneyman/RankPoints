package me.alex.RankPoints.Utils.Configuration;


import me.alex.RankPoints.RankPoints;
import me.alex.RankPoints.Utils.Utilities;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 7/15/2017.
 */
public class FileManager {

    private RankPoints plugin;
    private ArrayList<PluginFile> files;

    public FileManager(RankPoints plugin) {
        this.plugin = plugin;
        files = new ArrayList<PluginFile>();
        if(!plugin.getDataFolder().exists())
        {
            plugin.getDataFolder().mkdir();
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
             PluginFile pf = new PluginFile(f, plugin);
            this.files.add(pf);
            Utilities.debug(" Loaded file : " + pf.getName());


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
            if (f.getName().split(".")[0].equalsIgnoreCase(name)) {
                return f;
            }
            if (f.getName().split(".")[0].equalsIgnoreCase(name.split(".")[0])) {
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
