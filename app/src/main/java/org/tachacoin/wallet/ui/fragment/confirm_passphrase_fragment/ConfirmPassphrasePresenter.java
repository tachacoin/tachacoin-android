package org.tachacoin.wallet.ui.fragment.confirm_passphrase_fragment;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;


public interface ConfirmPassphrasePresenter extends BaseFragmentPresenter{
    void onResetAllClick();
    void seedEntered(List<String> seed);
}
