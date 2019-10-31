package org.tachacoin.wallet.ui.fragment.qstore;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface QStorePresenter extends BaseFragmentPresenter {
    void searchItems(String seacrhBarText, boolean checked);
}
