package org.tachacoin.wallet.ui.fragment.news_detail_fragment.tag_view_holders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jsoup.nodes.Element;
import org.tachacoin.wallet.R;
import org.tachacoin.wallet.ui.fragment.news_detail_fragment.LiTagAdapter;

import butterknife.BindView;

public class TagUlViewHolder extends TagViewHolder {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @LayoutRes
    int mResId;

    public TagUlViewHolder(View itemView) {
        super(itemView);
    }

    public TagUlViewHolder(View itemView, @LayoutRes int resId) {
        super(itemView);
        mResId = resId;
    }

    @Override
    public void bindElement(Element element) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        LiTagAdapter liTagAdapter = new LiTagAdapter(element.children(), mResId);
        mRecyclerView.setAdapter(liTagAdapter);
    }
}
