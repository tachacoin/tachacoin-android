package org.tachacoin.wallet.ui.fragment.currency_fragment.light;

import org.tachacoin.wallet.model.Currency;
import org.tachacoin.wallet.ui.fragment.currency_fragment.CurrencyFragment;

import java.util.List;

public class CurrencyFragmentLight extends CurrencyFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_currency_light;
    }

    @Override
    public void setCurrencyList(List<Currency> currencyList) {
        mCurrencyAdapter = new CurrencyAdapter(currencyList, org.tachacoin.wallet.R.layout.lyt_token_list_item_light);
        mCurrentList = currencyList;
        mRecyclerView.setAdapter(mCurrencyAdapter);
    }
}
