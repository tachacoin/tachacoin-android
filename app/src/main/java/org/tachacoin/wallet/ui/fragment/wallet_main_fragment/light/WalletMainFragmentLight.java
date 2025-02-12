package org.tachacoin.wallet.ui.fragment.wallet_main_fragment.light;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import org.tachacoin.wallet.ui.fragment.wallet_main_fragment.WalletMainFragment;

import butterknife.BindView;

public class WalletMainFragmentLight extends WalletMainFragment implements ViewPager.OnPageChangeListener {

    @BindView(org.tachacoin.wallet.R.id.wallet_indicator)
    ImageView walletIndicator;

    @BindView(org.tachacoin.wallet.R.id.other_tokens_indicator)
    ImageView otherTokensIndicator;

    @BindView(org.tachacoin.wallet.R.id.page_indicator)
    public View pagerIndicator;

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_wallet_main_light;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageSelected(int position) {
        if (pagerIndicator.getVisibility() == View.VISIBLE) {
            walletIndicator.setImageResource((position == 0) ? org.tachacoin.wallet.R.drawable.tab_indicator_selected_light : org.tachacoin.wallet.R.drawable.tab_indicator_default_light);
            otherTokensIndicator.setImageResource((position == 0) ? org.tachacoin.wallet.R.drawable.tab_indicator_default_light : org.tachacoin.wallet.R.drawable.tab_indicator_selected_light);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void showPageIndicator() {
        pagerIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePageIndicator() {
        pagerIndicator.setVisibility(View.INVISIBLE);
    }
}
