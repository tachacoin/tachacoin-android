package org.tachacoin.wallet.ui.fragment.store_categories;

import android.content.Context;

import org.tachacoin.wallet.dataprovider.rest_api.tachacoin.TachacoinService;
import org.tachacoin.wallet.model.gson.QstoreContractType;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class StoreCategoriesInteractorImpl implements StoreCategoriesInteractor {
    private WeakReference<Context> mContext;

    public StoreCategoriesInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<QstoreContractType>> contractTypesObservable() {
        return TachacoinService.newInstance().getContractTypes();
    }
}
