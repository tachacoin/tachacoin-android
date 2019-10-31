package org.tachacoin.wallet.ui.fragment.store_categories.light;

import org.tachacoin.wallet.model.gson.QstoreContractType;
import org.tachacoin.wallet.ui.fragment.store_categories.StoreCategoriesAdapter;
import org.tachacoin.wallet.ui.fragment.store_categories.StoreCategoriesFragment;
import org.tachacoin.wallet.ui.fragment.store_categories.StoreCategoryViewHolder;

import java.util.List;

public class StoreCategoriesFragmentLight extends StoreCategoriesFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.lyt_store_categories_light;
    }

    @Override
    public void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener) {
        adapter = new StoreCategoriesAdapter(list, org.tachacoin.wallet.R.layout.lyt_store_category_list_item_light, listener);
        contentList.setAdapter(adapter);
    }
}
