package org.tachacoin.wallet.ui.fragment.store_categories;

import org.tachacoin.wallet.model.gson.QstoreContractType;

import java.util.List;

import rx.Observable;

public interface StoreCategoriesInteractor {
    Observable<List<QstoreContractType>> contractTypesObservable();
}
