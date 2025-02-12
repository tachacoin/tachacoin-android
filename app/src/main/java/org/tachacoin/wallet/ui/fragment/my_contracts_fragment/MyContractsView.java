package org.tachacoin.wallet.ui.fragment.my_contracts_fragment;

import org.tachacoin.wallet.model.contract.Contract;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface MyContractsView extends BaseFragmentView {
    void setUpRecyclerView(List<Contract> contractList, ContractItemListener contractItemListener);

    void setPlaceHolder();

    void showWizard();

    void updateRecyclerView(List<Contract> contracts);

    void openContractFunctionFragment(Contract contract);

    void openDeletedContractFragment(String contractAddress, String contractName);
}
