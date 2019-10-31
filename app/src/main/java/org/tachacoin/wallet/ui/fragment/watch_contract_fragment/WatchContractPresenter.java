package org.tachacoin.wallet.ui.fragment.watch_contract_fragment;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchContractPresenter extends BaseFragmentPresenter {
    void onOkClick(String name, String address, String ABIInterface);

    void onTemplateClick(ContractTemplate contractTemplate);
}
