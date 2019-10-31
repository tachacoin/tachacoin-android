package org.tachacoin.wallet.ui.fragment.event_log_fragment;


import org.tachacoin.wallet.model.gson.history.History;

public interface EventLogInteractor {
    History getHistory(String txHash);
}
