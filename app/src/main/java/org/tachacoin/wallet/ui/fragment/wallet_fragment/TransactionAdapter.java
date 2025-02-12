package org.tachacoin.wallet.ui.fragment.wallet_fragment;

import android.support.v7.widget.RecyclerView;
import org.tachacoin.wallet.model.gson.history.History;
import java.util.List;

public abstract class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<History> mHistoryList;
    protected History mHistory;
    protected final int TYPE_PROGRESS_BAR = 0;
    protected final int TYPE_TRANSACTION = 1;
    protected boolean mLoadingFlag = false;
    protected HistoryCountChangeListener mHistoryCountChangeListener;

    public History getItem(int position){
        return mHistoryList.get(position);
    }

    protected TransactionClickListener listener;

    public TransactionAdapter(List<History> historyList, TransactionClickListener listener) {
        mHistoryList = historyList;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == mHistoryList.size()){
            return TYPE_PROGRESS_BAR;
        }
        return TYPE_TRANSACTION;
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size()+1;
    }

    public void setHistoryList(List<History> historyList) {
        mHistoryList = historyList;
        if(mHistoryCountChangeListener!=null){
            mHistoryCountChangeListener.onCountChange(mHistoryList.size());
        }
    }

    public List<History> getHistoryList() {
        return mHistoryList;
    }

    public void setHistoryCountChangeListener(HistoryCountChangeListener historyCountChangeListener) {
        mHistoryCountChangeListener = historyCountChangeListener;
    }

    public void setLoadingFlag(boolean loadingFlag) {
        mLoadingFlag = loadingFlag;
    }
}
