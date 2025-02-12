package org.tachacoin.wallet.ui.fragment.send_fragment.light;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.model.gson.token_balance.TokenBalance;
import org.tachacoin.wallet.ui.activity.main_activity.MainActivity;
import org.tachacoin.wallet.ui.fragment.send_fragment.AddressWithTokenBalanceSpinnerAdapter;
import org.tachacoin.wallet.ui.fragment.send_fragment.SendFragment;
import org.tachacoin.wallet.utils.FontManager;

public class SendFragmentLight extends SendFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_send_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        ((MainActivity) getActivity()).showBottomNavigationView(R.color.title_color_light);
        mTextInputEditTextAddress.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaSemibold)));
        mTextInputEditTextAmount.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaSemibold)));
        mTextInputEditTextFee.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaSemibold)));
        tilAdress.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaRegular)));
        tilAmount.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaRegular)));
        tilFee.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaRegular)));
    }

    @Override
    public void setUpSpinner(TokenBalance tokenBalance, Integer decimalUnits) {
        if(adapter!=null &&
                ((AddressWithTokenBalanceSpinnerAdapter)mSpinner.getAdapter()).getTokenBalance().getContractAddress().equals(tokenBalance.getContractAddress())) {
            adapter.setTokenBalance(tokenBalance);
            adapter.notifyDataSetChanged();
        } else {
            adapter = new AddressWithTokenBalanceSpinnerAdapterLight(getContext(), tokenBalance, "", decimalUnits);
            mSpinner.setAdapter(adapter);
        }
        super.setUpSpinner(tokenBalance, decimalUnits);
    }
}
