package org.tachacoin.wallet.ui.fragment.set_your_token_fragment.light;

import org.tachacoin.wallet.model.contract.ContractMethodParameter;
import org.tachacoin.wallet.ui.fragment.set_your_token_fragment.SetYourTokenFragment;

import java.util.List;

public class SetYourTokenFragmentLight extends SetYourTokenFragment {

    private final int LAYOUT = org.tachacoin.wallet.R.layout.fragment_set_your_token_light;

    @Override
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    public void onContractConstructorPrepared(List<ContractMethodParameter> params) {
        adapter = new ConstructorAdapterLight(params, this);
        constructorList.setAdapter(adapter);
    }
}
