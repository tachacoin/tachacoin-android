package org.tachacoin.wallet.ui.fragment.pin_fragment.light;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.ui.activity.main_activity.MainActivity;
import org.tachacoin.wallet.ui.fragment.pin_fragment.PinFragment;
import org.tachacoin.wallet.ui.wave_visualizer.WaveHelper;
import org.tachacoin.wallet.ui.wave_visualizer.WaveView;

import butterknife.BindView;

public class PinFragmentLight extends PinFragment {

    @BindView(org.tachacoin.wallet.R.id.wave_view)
    WaveView waveView;
    private WaveHelper mWaveHelper;

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_pin_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        mWaveHelper = new WaveHelper(waveView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWaveHelper.start();
    }

    @Override
    public void onPause() {
        mWaveHelper.cancel();
        super.onPause();
    }

    @Override
    public int getThemedStatusBarColor() {
        return R.color.title_color_light;
    }
}
