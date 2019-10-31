package org.tachacoin.wallet.dataprovider.services.update_service.listeners;

import org.tachacoin.wallet.model.gson.history.History;

public interface TransactionListener {
    void onNewHistory(History history);

    boolean getVisibility();
}
