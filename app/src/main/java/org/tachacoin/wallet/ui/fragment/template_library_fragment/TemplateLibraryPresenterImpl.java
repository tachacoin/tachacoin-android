package org.tachacoin.wallet.ui.fragment.template_library_fragment;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TemplateLibraryPresenterImpl extends BaseFragmentPresenterImpl implements TemplateLibraryPresenter {

    private TemplateLibraryView mTemplateLibraryView;
    private TemplateLibraryInteractor mTemplateLibraryInteractor;

    public TemplateLibraryPresenterImpl(TemplateLibraryView view, TemplateLibraryInteractor interactor) {
        mTemplateLibraryView = view;
        mTemplateLibraryInteractor = interactor;
    }

    @Override
    public TemplateLibraryView getView() {
        return mTemplateLibraryView;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        List<ContractTemplate> contractFullTemplateList = new ArrayList<>();

        List<ContractTemplate> contractTemplateList = getInteractor().getContactTemplates();

        for (ContractTemplate contractTemplate : contractTemplateList) {
            if (contractTemplate.isFullContractTemplate()) {
                contractFullTemplateList.add(contractTemplate);
            }
        }
        Collections.sort(contractFullTemplateList, new Comparator<ContractTemplate>() {
            @Override
            public int compare(ContractTemplate contractInfo, ContractTemplate t1) {
                return contractInfo.getDate().compareTo(t1.getDate());
            }
        });

        getView().setUpTemplateList(contractFullTemplateList);
    }

    public TemplateLibraryInteractor getInteractor() {
        return mTemplateLibraryInteractor;
    }
}
