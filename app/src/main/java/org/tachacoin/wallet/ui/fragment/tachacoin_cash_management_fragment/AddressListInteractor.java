package org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment;

import org.tachacoin.wallet.model.gson.UnspentOutput;

import java.util.List;

import rx.Observable;

public interface AddressListInteractor {
    List<String> getAddresses();

    Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses);
}
