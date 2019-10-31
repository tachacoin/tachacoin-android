package org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment;

import org.tachacoin.wallet.model.AddressWithBalance;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressListView extends BaseFragmentView {
    void updateAddressList(List<AddressWithBalance> deterministicKeyWithBalance);
}
