package me.alex.RankPoints.Utils.SavedConfigurations;


import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public enum ConfigValues {

    POINTSPERTIER(1,"RankPoints.PointsPerTier"),
    MONEYPERTIER(100,"RankPoints.MoneyPerTier"),
    TIMEBETWEENKILLS(30,"RankPoints.TimeBetweenKills");

    private int value;
    private String path;

    ConfigValues(int i,String s)
    {
        value = i;
        path = s;


    }

    public int getValue()
    {
        return value;

    }

    public String getPath()
    {
        return null;
    }

    public void setValue(int i)
    {
        value = i;
    }

    static
    {
        Plugin p = Bukkit.getServer().getPluginManager().getPlugin("RankPoints");



    }
}
