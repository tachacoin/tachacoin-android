package org.tachacoin.wallet.ui.fragment.my_contracts_fragment.dark;

import org.tachacoin.wallet.model.contract.Contract;
import org.tachacoin.wallet.ui.fragment.my_contracts_fragment.ContractItemListener;
import org.tachacoin.wallet.ui.fragment.my_contracts_fragment.MyContractsFragment;

import java.util.List;

public class MyContractsFragmentDark extends MyContractsFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_my_contracts;
    }


    @Override
    public void setUpRecyclerView(List<Contract> contractList, ContractItemListener contractItemListener) {
        mContractAdapter = new ContractAdapter(contractList, org.tachacoin.wallet.R.layout.item_contract_list, contractItemListener);
        mRecyclerView.setAdapter(mContractAdapter);
    }
}
