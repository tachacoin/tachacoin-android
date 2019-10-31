package org.tachacoin.wallet.ui.fragment.token_fragment;

import org.tachacoin.wallet.model.contract.Token;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface TokenPresenter extends BaseFragmentPresenter {
    Token getToken();

    void setToken(Token token);

    String getAbi();

    void onDecimalsPropertySuccess(String value);

    String onTotalSupplyPropertySuccess(Token token, String value);

    void onLastItem(int currentItemCount);

    void onTransactionClick(String txHash);

    void onNetworkStateChanged(boolean networkConnectedFlag);
}
