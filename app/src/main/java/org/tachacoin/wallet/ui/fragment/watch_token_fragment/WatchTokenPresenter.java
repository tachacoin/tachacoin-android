package org.tachacoin.wallet.ui.fragment.watch_token_fragment;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchTokenPresenter extends BaseFragmentPresenter {

    void onOkClick(String name, String address);

    void onContractAddressEntered(String contractAddress);

}
