package org.tachacoin.wallet.ui.fragment.qstore_by_type.light;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.model.gson.qstore.QSearchItem;
import org.tachacoin.wallet.ui.fragment.qstore_by_type.QStoreByTypeFragment;
import org.tachacoin.wallet.ui.fragment.qstore_by_type.StoreSearchAdapter;

import java.util.List;

public class QStoreByTypeFragmentLight extends QStoreByTypeFragment {

    @Override
    protected int getLayout() {
        return R.layout.lyt_q_store_light;
    }

    @Override
    public void setSearchResult(List<QSearchItem> items) {
        searchAdapter = new StoreSearchAdapter(items, this, R.layout.lyt_store_search_list_item_light);
        contentList.setAdapter(searchAdapter);
    }
}
