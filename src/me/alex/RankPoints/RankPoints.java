package me.alex.RankPoints;

import com.google.common.collect.Maps;
import me.alex.RankPoints.Listeners.RPOnKill;
import me.alex.RankPoints.Utils.Configuration.FileManager;
import me.alex.RankPoints.Utils.Configuration.Files.MessagesFile;
import me.alex.RankPoints.Utils.Configuration.PluginFile;
import me.alex.RankPoints.Utils.SavedConfigurations.ConfigOptions;
import me.alex.RankPoints.Utils.Utilities;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;


public class RankPoints extends JavaPlugin {

    Permission perms;
    Economy econ;

    public HashMap<Integer, String> ranks = Maps.newHashMap();

    public void onEnable()
    {
        if(setupPermissions())
        {
            Utilities.debug("Sucessfully hooked with Vault permissions");

        } else
        {
            Utilities.error("Vault could not be hooked");
             Bukkit.getPluginManager().disablePlugin(this);
        }

        if(setupEconomy())
        {
            Utilities.info("Sucessfully hooked with Vault economy");
        } else
        {
            Utilities.error("Vault could not be hooked with economy, all features dealing with money are disabled");
        }

        loadClasses();


    }

    public void onDisable()
    {



    }

    public RPOnKill rponkill;
    public FileManager fm;
    public MessagesFile mf;
    public PluginFile cf;

    private void loadClasses()
    {
        rponkill = new RPOnKill(this);
        fm = new FileManager(this);

        mf = (MessagesFile)fm.getPluginFile("messages.yml");
        cf = fm.getPluginFile("config.yml");
        Utilities.debug("Method 'loadClasses' loaded cf & mf variables at : " + System.currentTimeMillis());


    }

    private void loadConfigOptions()
    {
        ConfigOptions.ECONOMY.setValue(econ == null ? false : true);
        ConfigOptions.PAY_OUT_MONEY.setValue(getConfig().getBoolean("RankPoints.PayOutMoney"));
        ConfigOptions.RANK_VOUCHERS.setValue(getConfig().getBoolean("RankPoints.RankVouchers.Enabled"));
        ConfigOptions.RANK_VOUCHERS_USE_CUSTOMCMDS.setValue(getConfig().getBoolean("RankPoints.RankVouchers.UseCustomCmds"));


    }

    @Override
    public FileConfiguration getConfig()
    {
        return cf.getConfig();
    }

    public PluginFile getConfigFile()
    {
        return cf;
    }

    public MessagesFile getMessageFile() {
        return mf;
    }

    public FileManager getFileManager() {
        return fm;
    }


    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public int getRankDistance(String killerRank, String killedRank)
    {
        int returnInt = 0;
        int killerInt = 0;
        int killedInt = 0;

        if(ranks.isEmpty())
        {
            for(String ranknum : getConfig().getConfigurationSection("Ranks").getKeys(false))
            {
                if(ranknum != "BaseRank")
                {
                    try {
                        int rankNumber = Integer.parseInt(ranknum);
                        String s = getConfig().getString("Ranks." + rankNumber + ".Name");

                        Utilities.debug("RankNumber : " + ranknum + ", And Rank : " + s + " are loaded");
                        ranks.put(rankNumber, s);



                    }catch(Throwable e)
                    {
                        Utilities.error("[RankPoints] The rank number " + ranknum + " is not an integer!");
                    }


                }

            }


        }

        for(Map.Entry entry : ranks.entrySet())
        {
         String rank = (String)entry.getValue();
             if(killedRank.equalsIgnoreCase(rank))
             {
                 killedInt = (int)entry.getKey();


             }
            if(killerRank.equalsIgnoreCase(rank))
            {
                killerInt = (int)entry.getKey();


            }
            returnInt = killedInt-killerInt;
        }

        Utilities.debug("Returned : " + returnInt);


        if(returnInt < 0) return 0;
        return returnInt;
    }

    public int getRankDistance(Player killed, Player killer)
    {
        String killedRank = perms.getPrimaryGroup(killed);
        String killerRank = perms.getPrimaryGroup(killer);

        return getRankDistance(killerRank, killedRank);
    }
}
