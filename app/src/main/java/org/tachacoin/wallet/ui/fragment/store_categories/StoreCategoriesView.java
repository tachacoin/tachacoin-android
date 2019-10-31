package org.tachacoin.wallet.ui.fragment.store_categories;

import org.tachacoin.wallet.model.gson.QstoreContractType;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface StoreCategoriesView extends BaseFragmentView {
    void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener);
}
