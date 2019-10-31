package org.tachacoin.wallet.listener;

import org.tachacoin.wallet.entity.HeaderData;

/**
 * Created by kirillvolkov on 22.11.2017.
 */

public interface HeaderClickListener {
    void onHeaderClick(HeaderData headerData);
}
