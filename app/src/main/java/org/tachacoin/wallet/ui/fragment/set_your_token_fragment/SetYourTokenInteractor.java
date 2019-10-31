package org.tachacoin.wallet.ui.fragment.set_your_token_fragment;

import org.tachacoin.wallet.model.contract.ContractMethod;

public interface SetYourTokenInteractor {
    ContractMethod getContractConstructor(String uiid);
}
