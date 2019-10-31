package org.tachacoin.wallet.ui.fragment.watch_token_fragment.light;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.tachacoin.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.tachacoin.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.tachacoin.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import org.tachacoin.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentLight extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_watch_token_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.tachacoin.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.tachacoin.wallet.R.string.proximaNovaSemibold)));
    }

}
