package org.tachacoin.wallet.utils;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.TachacoinMainNetParams;
import org.bitcoinj.params.TachacoinTestNetParams;
import org.tachacoin.wallet.BuildConfig;

public class CurrentNetParams {

    public  CurrentNetParams(){}

    public static NetworkParameters getNetParams(){
        return BuildConfig.USE_MAIN_NET? TachacoinMainNetParams.get() : TachacoinTestNetParams.get();
    }

    public static String getUrl(){
        return BuildConfig.API_URL;
    }
}
