package org.tachacoin.wallet.ui.fragment.qstore_by_type;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface QStoreByTypePresenter extends BaseFragmentPresenter {
    void searchItems(String s, boolean checked);
}
