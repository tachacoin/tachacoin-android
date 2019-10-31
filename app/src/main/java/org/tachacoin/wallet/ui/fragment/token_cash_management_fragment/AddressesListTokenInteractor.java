package org.tachacoin.wallet.ui.fragment.token_cash_management_fragment;

import org.bitcoinj.crypto.DeterministicKey;
import org.tachacoin.wallet.model.AddressWithTokenBalance;
import org.tachacoin.wallet.model.gson.token_balance.TokenBalance;

import java.util.List;

public interface AddressesListTokenInteractor {
    boolean isCurrencyValid(String currency);

    boolean isAmountValid(String amountString);

    List<String> getAddresses();

    boolean isValidForAddress(TokenBalance tokenBalance, AddressWithTokenBalance keyWithTokenBalanceFrom);

    boolean isValidBalance(TokenBalance tokenBalance, AddressWithTokenBalance keyWithTokenBalanceFrom, String amountString, Integer decimalUnits);
}
