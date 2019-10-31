package org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment.dark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import org.tachacoin.wallet.model.AddressWithBalance;
import org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment.AddressesWithBalanceSpinnerAdapter;

import java.util.List;

public class AddressesWithBalanceSpinnerAdapterDark extends AddressesWithBalanceSpinnerAdapter {

    public AddressesWithBalanceSpinnerAdapterDark(@NonNull Context context, List<AddressWithBalance> keyWithBalanceList) {
        super(context, keyWithBalanceList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, org.tachacoin.wallet.R.layout.item_address_spinner, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, org.tachacoin.wallet.R.layout.item_address_spinner_dropdown, parent);
    }
}
