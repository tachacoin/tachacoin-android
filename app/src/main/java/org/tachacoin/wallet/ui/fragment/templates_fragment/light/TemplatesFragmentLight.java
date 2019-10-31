package org.tachacoin.wallet.ui.fragment.templates_fragment.light;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.fragment.templates_fragment.TemplatesFragment;

import java.util.List;

public class TemplatesFragmentLight extends TemplatesFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_templates_light;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, R.layout.item_template_light);
    }
}
