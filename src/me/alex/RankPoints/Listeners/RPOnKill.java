package me.alex.RankPoints.Listeners;

import me.alex.RankPoints.RankPoints;
import me.alex.RankPoints.Utils.SavedConfigurations.ConfigOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class RPOnKill implements Listener {

    RankPoints plugin;

    public RPOnKill(RankPoints rp)
    {
        plugin = rp;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);


    }


    @EventHandler
    public void onKill(PlayerDeathEvent e)
    {
        Player killer = e.getEntity().getKiller();
        Player dead = e.getEntity();
        int rankDistance = plugin.getRankDistance(killer,dead);
        if(ConfigOptions.PAY_OUT_MONEY.getValue())
        {


        }





    }
}
