package org.tachacoin.wallet.ui.fragment.backup_wallet_fragment;

import android.content.Context;
import android.util.Base64;

import org.tachacoin.wallet.datastorage.TachacoinSharedPreference;
import org.tachacoin.wallet.utils.crypto.AESUtil;
import org.tachacoin.wallet.utils.crypto.KeyStoreHelper;

class BackUpWalletInteractorImpl implements BackUpWalletInteractor {

    private Context mContext;

    private final String TACHACOIN_PIN_ALIAS = "tachacoin_alias";

    BackUpWalletInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getPassphrase(String pin) {
       return KeyStoreHelper.getSeed(mContext, pin);
    }
}
