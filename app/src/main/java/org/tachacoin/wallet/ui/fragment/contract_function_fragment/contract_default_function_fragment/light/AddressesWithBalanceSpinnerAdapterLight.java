package org.tachacoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.light;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.model.AddressWithBalance;
import org.tachacoin.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.AddressesWithBalanceSpinnerAdapter;

import java.util.List;

public class AddressesWithBalanceSpinnerAdapterLight extends AddressesWithBalanceSpinnerAdapter {

    public AddressesWithBalanceSpinnerAdapterLight(@NonNull Context context, List<AddressWithBalance> keyWithBalanceList) {
        super(context, keyWithBalanceList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, R.layout.item_address_spinner_light, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomDropDownView(position, R.layout.item_address_spinner_dropdown_light, parent);
    }
}
