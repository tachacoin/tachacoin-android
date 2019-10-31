package org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment;

import org.tachacoin.wallet.model.AddressWithBalance;

public interface OnAddressClickListener {
    void onItemClick(AddressWithBalance deterministicKeyWithBalance);
}
