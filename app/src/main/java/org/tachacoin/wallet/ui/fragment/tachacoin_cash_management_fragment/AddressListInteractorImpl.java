package org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment;

import android.content.Context;

import org.tachacoin.wallet.dataprovider.rest_api.tachacoin.TachacoinService;
import org.tachacoin.wallet.datastorage.KeyStorage;

import org.tachacoin.wallet.model.gson.UnspentOutput;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class AddressListInteractorImpl implements AddressListInteractor {

    AddressListInteractorImpl() {
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return TachacoinService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }
}
