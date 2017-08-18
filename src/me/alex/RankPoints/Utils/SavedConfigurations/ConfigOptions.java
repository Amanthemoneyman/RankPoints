package me.alex.RankPoints.Utils.SavedConfigurations;

public enum ConfigOptions {


    PAY_OUT_MONEY(Boolean.FALSE,"PayOutMoney")
    ,TAKE_MONEY(Boolean.FALSE,"TakeMoney")
    ,RANK_VOUCHERS(Boolean.TRUE,"RankVouchersEnabled")
    ,RANK_VOUCHERS_USE_CUSTOMCMDS(Boolean.FALSE,"RankVouchersUseCustomCmds")
    ,ECONOMY(Boolean.TRUE,"EconomyEnabled");


    private boolean bool;
    private final String stringValue;
     ConfigOptions(boolean b, String s)
     {
                b = bool;
                stringValue = s;
     }

    public boolean getValue()
    {
        return bool;
    }

    public void setValue(boolean b)
    {
        bool = b;
    }

    @Override
    public String toString()
    {
        return stringValue;


    }


}
