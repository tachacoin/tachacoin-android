package org.tachacoin.wallet.ui.fragment.contract_management_fragment;

import org.tachacoin.wallet.model.contract.Contract;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface ContractManagementPresenter extends BaseFragmentPresenter {
    Contract getContractByAddress(String contractAddress);
}
