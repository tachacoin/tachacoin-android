package org.tachacoin.wallet.ui.fragment.watch_token_fragment;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragment;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface WatchTokenView extends BaseFragmentView {

    void subscribeTokenBalanceChanges(String contractAddress);

    BaseFragment.AlertDialogCallBack getAlertCallback();

    void setContractName(String contractName);

}
