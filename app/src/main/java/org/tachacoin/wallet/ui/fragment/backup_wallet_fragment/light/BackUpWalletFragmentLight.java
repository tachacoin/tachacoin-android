package org.tachacoin.wallet.ui.fragment.backup_wallet_fragment.light;

import org.tachacoin.wallet.ui.fragment.backup_wallet_fragment.BackUpWalletFragment;

public class BackUpWalletFragmentLight extends BackUpWalletFragment {
    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_back_up_wallet_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        getMainActivity().recolorStatusBar(org.tachacoin.wallet.R.color.title_color_light);
    }
}
