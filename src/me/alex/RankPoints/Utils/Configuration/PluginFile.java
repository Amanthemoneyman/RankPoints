package me.alex.RankPoints.Utils.Configuration;
import me.alex.RankPoints.RankPoints;
import me.alex.RankPoints.Utils.Utilities;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 7/14/2017.
 */
public class PluginFile extends File{

    protected FileConfiguration config;
    protected FileType type;
    protected RankPoints plugin;
    private FileManager fm;

    public PluginFile(File pluginFile, RankPoints plugin)
    {
        super(plugin.getDataFolder(),pluginFile.getName());
        this.plugin = plugin;
        if (!this.exists()) {
            try {
                if (!this.getName().endsWith(".yml")) {

                    if(this.getName().endsWith(".txt"))
                    {
                        type = FileType.TXT;
                    } else { type = FileType.OTHER; }
                    mkdir();
                } else {
                    createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (this.getName().endsWith(".yml"))
        {
            type = FileType.YML;
            this.loadFileConfiguration();

        }

    }

    public PluginFile(String fileName, RankPoints plugin)
    {
        super(plugin.getDataFolder(),fileName);
        this.plugin = plugin;
        if (!this.exists()) {
                if (!this.getName().endsWith(".yml")) {

                    if(this.getName().endsWith(".txt"))
                    {
                        type = FileType.TXT;
                    } else { type = FileType.OTHER; }
                    mkdir();
                } else {
                      plugin.saveResource(this.getName(), false);
                }
        }

        if (this.getName().endsWith(".yml"))
            type = FileType.YML;
        this.loadFileConfiguration();


    }


    public void saveFile()
    {
        try {
            this.config.save(this);
            Utilities.debug(this.getName() + " has been saved");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void loadFileConfiguration()
    {
        if(this.getType() == FileType.YML) {
            try {

                config = YamlConfiguration.loadConfiguration(this);
                Utilities.debug(this.getName() + " has been loaded.");

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        } else
        {
            Utilities.debug("File : " + getName() + " is not a yml file therfore the configuration was not loaded");
        }



    }

    public FileType getType()
    { return this.type; }

    public FileConfiguration getConfig() {
        return config;
    }
}
