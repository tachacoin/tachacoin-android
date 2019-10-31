package org.tachacoin.wallet.ui.fragment.token_fragment.light;

import android.support.design.widget.AppBarLayout;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.model.gson.token_history.TokenHistory;
import org.tachacoin.wallet.ui.fragment.token_fragment.TokenFragment;
import org.tachacoin.wallet.ui.fragment.token_fragment.dark.TokenHistoryAdapterDark;
import org.tachacoin.wallet.ui.wave_visualizer.WaveHelper;
import org.tachacoin.wallet.ui.wave_visualizer.WaveView;
import org.tachacoin.wallet.utils.ContractBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TokenFragmentLight extends TokenFragment {

    private final int LAYOUT = org.tachacoin.wallet.R.layout.lyt_token_fragment_light;

    @BindView(org.tachacoin.wallet.R.id.wave_view)
    WaveView waveView;
    private WaveHelper mWaveHelper;

    @BindView(org.tachacoin.wallet.R.id.bt_share)
    ImageButton mShareBtn;

    @BindView(org.tachacoin.wallet.R.id.iv_choose_address)
    ImageView mIvChooseAddress;

    @BindView(org.tachacoin.wallet.R.id.tv_token_name)
    TextView mTokenTitle;

    @BindView(R.id.ll_balance)
    LinearLayout llBalance;

    @Override
    protected int getLayout() {
        return LAYOUT;
    }

    AppBarLayout.OnOffsetChangedListener appBarLayoutListener =  new AppBarLayout.OnOffsetChangedListener() {
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            percents = (((getTotalRange() - Math.abs(verticalOffset)) * 1.0f) / getTotalRange());
            float offsetPercents = percents - (1 - percents);
            balanceView.setAlpha(offsetPercents);
            prevPercents = percents;
        }
    };

    @Override
    public void initializeViews() {
        super.initializeViews();
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        mWaveHelper = new WaveHelper(waveView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAppBarLayout.addOnOffsetChangedListener(appBarLayoutListener);
        mWaveHelper.start();
    }

    @Override
    public void onPause() {
        mAppBarLayout.removeOnOffsetChangedListener(appBarLayoutListener);
        mWaveHelper.cancel();
        super.onPause();
    }

    @Override
    public void setBalance(final String balance) {
        llBalance.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llBalance.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mTextViewBalance.setLongNumberText(balance, llBalance.getWidth() * 2 / 3);
            }
        });
    }

    @Override
    public void onContractPropertyUpdated(String propName, String propValue) {
        switch (propName) {
            case totalSupply:
                totalSupplyValue.setText(ContractBuilder.getShortBigNumberRepresentation(propValue, 10));
                break;
            case decimals:
                decimalsValue.setText(propValue);
                break;
            case symbol:
                mTextViewCurrency.setText(" " + propValue);
                break;
            case name:
                mTextViewTokenName.setText(propValue);
                break;
        }
    }

    @Override
    protected void createAdapter() {
        mAdapter = new TokenHistoryAdapterLight(new ArrayList<TokenHistory>(),this,token.getDecimalUnits());
        mRecyclerView.setAdapter(mAdapter);
    }

}
