package org.tachacoin.wallet.ui.fragment.watch_contract_fragment;

import org.tachacoin.wallet.model.ContractTemplate;

public interface OnTemplateClickListener {
    void updateSelection(int adapterPosition);

    void onTemplateClick(ContractTemplate contractTemplate);
}
