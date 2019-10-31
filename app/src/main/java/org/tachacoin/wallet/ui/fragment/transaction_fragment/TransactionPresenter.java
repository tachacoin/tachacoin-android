package org.tachacoin.wallet.ui.fragment.transaction_fragment;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface TransactionPresenter extends BaseFragmentPresenter {
    void openTransactionView(String txHash, HistoryType historyType);
}
