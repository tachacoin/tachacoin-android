package org.tachacoin.wallet.ui.fragment.watch_contract_fragment.light;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.tachacoin.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.tachacoin.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.tachacoin.wallet.utils.FontManager;

import java.util.List;

public class WatchContractFragmentLight extends WatchContractFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_watch_contract_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.tachacoin.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.tachacoin.wallet.R.string.proximaNovaSemibold)));
    }

    @Override
    public void setUpTemplatesList(List<ContractTemplate> contractTemplateList, OnTemplateClickListener listener) {
        mRecyclerViewTemplates.setAdapter(new TemplatesAdapter(contractTemplateList, listener, org.tachacoin.wallet.R.layout.item_template_chips_light, org.tachacoin.wallet.R.drawable.chip_selected_corner_background));
    }
}
