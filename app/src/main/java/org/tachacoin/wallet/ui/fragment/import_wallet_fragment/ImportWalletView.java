package org.tachacoin.wallet.ui.fragment.import_wallet_fragment;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;
import org.tachacoin.wallet.ui.fragment.pin_fragment.PinAction;

public interface ImportWalletView extends BaseFragmentView {
    void enableImportButton();

    void disableImportButton();

    void openPinFragment(String passphrase, PinAction action);
}
