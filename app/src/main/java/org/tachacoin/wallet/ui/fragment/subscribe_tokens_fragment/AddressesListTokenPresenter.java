package org.tachacoin.wallet.ui.fragment.subscribe_tokens_fragment;

import org.tachacoin.wallet.model.contract.Token;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter {
    void onSubscribeChanged(Token token);
}
