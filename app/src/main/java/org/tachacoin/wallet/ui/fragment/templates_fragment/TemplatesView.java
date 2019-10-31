package org.tachacoin.wallet.ui.fragment.templates_fragment;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplatesView extends BaseFragmentView {
    void setUpTemplateList(List<ContractTemplate> contractTemplateList);
}
