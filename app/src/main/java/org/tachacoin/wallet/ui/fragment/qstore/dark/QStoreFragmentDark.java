package org.tachacoin.wallet.ui.fragment.qstore.dark;

import org.tachacoin.wallet.model.gson.qstore.QSearchItem;
import org.tachacoin.wallet.ui.fragment.qstore.QStoreFragment;
import org.tachacoin.wallet.ui.fragment.qstore.StoreAdapter;
import org.tachacoin.wallet.ui.fragment.qstore.StoreSearchAdapter;
import org.tachacoin.wallet.ui.fragment.qstore.categories.QstoreCategory;

import java.util.List;

public class QStoreFragmentDark extends QStoreFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.lyt_q_store;
    }

    @Override
    public void setCategories(List<QstoreCategory> categories) {
        storeAdapter = new StoreAdapter(categories, this, org.tachacoin.wallet.R.layout.lyt_store_list_item, org.tachacoin.wallet.R.layout.lyt_store_token_list_item);
        contentList.setAdapter(storeAdapter);
    }

    @Override
    public void setSearchResult(List<QSearchItem> items) {
        searchAdapter = new StoreSearchAdapter(items, this, org.tachacoin.wallet.R.layout.lyt_store_search_list_item);
        contentList.setAdapter(searchAdapter);
    }
}
