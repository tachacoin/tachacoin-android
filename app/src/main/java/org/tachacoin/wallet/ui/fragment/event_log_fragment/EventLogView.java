package org.tachacoin.wallet.ui.fragment.event_log_fragment;

import org.tachacoin.wallet.model.gson.history.Log;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;


public interface EventLogView extends BaseFragmentView {
    String getTxHash();
    void updateEventLog(List<Log> logs);
}
