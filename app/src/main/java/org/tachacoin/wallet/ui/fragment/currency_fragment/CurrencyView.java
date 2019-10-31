package org.tachacoin.wallet.ui.fragment.currency_fragment;

import org.tachacoin.wallet.model.Currency;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface CurrencyView extends BaseFragmentView {
    void setCurrencyList(List<Currency> currencyList);
}
