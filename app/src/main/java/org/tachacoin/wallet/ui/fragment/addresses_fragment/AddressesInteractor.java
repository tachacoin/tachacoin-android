package org.tachacoin.wallet.ui.fragment.addresses_fragment;

import org.bitcoinj.crypto.DeterministicKey;

import java.util.List;

public interface AddressesInteractor {
    List<String> getKeyList();
}
