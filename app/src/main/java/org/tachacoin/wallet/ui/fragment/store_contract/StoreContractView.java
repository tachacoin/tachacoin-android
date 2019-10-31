package org.tachacoin.wallet.ui.fragment.store_contract;

import org.tachacoin.wallet.model.gson.qstore.QstoreContract;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface StoreContractView extends BaseFragmentView {
    void setContractData(QstoreContract contract);

    void openAbiViewer(String abi);

    void openSourceCode(String sourceCode);

    void openDetails(String abi);

    void setContractPayStatus(String status);

    void disablePurchase();
}

