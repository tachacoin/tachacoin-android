package org.tachacoin.wallet.ui.fragment.template_library_fragment.dark;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.fragment.template_library_fragment.TemplateLibraryFragment;

import java.util.List;

public class TemplateLibraryFragmentDark extends TemplateLibraryFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_template_library;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.tachacoin.wallet.R.layout.item_template);
    }
}
