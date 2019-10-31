package org.tachacoin.wallet.ui.fragment.template_library_fragment;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplateLibraryView extends BaseFragmentView {

    void setUpTemplateList(List<ContractTemplate> contractTemplateList);

}
