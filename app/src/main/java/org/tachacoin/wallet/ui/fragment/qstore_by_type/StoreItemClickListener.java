package org.tachacoin.wallet.ui.fragment.qstore_by_type;

import org.tachacoin.wallet.model.gson.qstore.QstoreItem;

interface StoreItemClickListener {
    void OnItemClick(QstoreItem item);
}
