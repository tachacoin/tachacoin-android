package org.tachacoin.wallet.ui.fragment.templates_fragment.dark;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.fragment.templates_fragment.TemplatesFragment;

import java.util.List;

public class TemplatesFragmentDark extends TemplatesFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_templates;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.tachacoin.wallet.R.layout.item_template);
    }
}
