package org.tachacoin.wallet.ui.fragment.other_tokens;

import org.tachacoin.wallet.model.contract.Token;

import java.util.List;

import rx.Observable;

public interface OtherTokensInteractor {
    Observable<List<Token>> getTokenObservable();
}
