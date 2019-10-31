package org.tachacoin.wallet.ui.fragment.my_contracts_fragment;

import org.tachacoin.wallet.model.contract.Contract;

public interface ContractItemListener {
    void onUnsubscribeClick(Contract contract);
}
