package org.tachacoin.wallet.dataprovider.services.update_service.listeners;

import org.tachacoin.wallet.model.gson.token_balance.TokenBalance;

public interface TokenBalanceChangeListener {
    void onBalanceChange(TokenBalance tokenBalance);
}
