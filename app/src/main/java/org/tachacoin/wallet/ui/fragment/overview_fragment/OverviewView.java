package org.tachacoin.wallet.ui.fragment.overview_fragment;


import android.util.Pair;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;
import org.tachacoin.wallet.ui.fragment.transaction_fragment.HistoryType;

import java.util.List;

public interface OverviewView extends BaseFragmentView{
    String getTxHash();
    HistoryType getHistoryType();
    void setUpOverview(List<CopyableOverviewItem> overview);
}
