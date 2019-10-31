package org.tachacoin.wallet.ui.fragment.addresses_detail_fragment;


import org.tachacoin.wallet.model.gson.history.History;
import org.tachacoin.wallet.model.gson.token_history.TokenHistory;


public interface AddressesDetailInteractor {
    History getHistory(String txHash);
    TokenHistory getTokenHistory(String txHash);
}
