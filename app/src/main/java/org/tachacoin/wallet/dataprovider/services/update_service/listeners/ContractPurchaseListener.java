package org.tachacoin.wallet.dataprovider.services.update_service.listeners;

import org.tachacoin.wallet.model.gson.qstore.ContractPurchase;

public interface ContractPurchaseListener {
    void onContractPurchased(ContractPurchase purchaseData);
}
