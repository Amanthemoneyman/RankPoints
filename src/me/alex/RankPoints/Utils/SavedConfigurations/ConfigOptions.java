package me.alex.RankPoints.Utils.SavedConfigurations;

public enum ConfigOptions {


    PAYOUTMONEY(Boolean.FALSE,"PayOutMoney")
    ,TAKEMONEY(Boolean.FALSE,"TakeMoney")
    ,RANKVOUCHERSENABLED(Boolean.TRUE,"RankVoucherEnabled"
    ),RANKVOUCHERSUSECUSTOMCMDS(Boolean.FALSE,"RankVoucherCustomCmds");


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
