package org.tachacoin.wallet.ui.fragment.language_fragment.light;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Pair;
import android.view.View;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.datastorage.TachacoinSettingSharedPreference;
import org.tachacoin.wallet.datastorage.TachacoinSharedPreference;
import org.tachacoin.wallet.ui.fragment.language_fragment.LanguageHolder;
import org.tachacoin.wallet.ui.fragment.language_fragment.OnLanguageIntemClickListener;

public class LanguageHolderLight extends LanguageHolder {
    public LanguageHolderLight(View itemView, OnLanguageIntemClickListener listener) {
        super(itemView, listener);
    }

    public void bindLanguage(Pair<String, String> language) {
        if (language.first.equals(TachacoinSettingSharedPreference.getInstance().getLanguage(mTextViewLanguage.getContext()))) {
            mImageViewCheckIndicator.setVisibility(View.VISIBLE);
            mLinearLayoutAddress.setBackgroundColor(ContextCompat.getColor(mTextViewLanguage.getContext(), R.color.qr_code_background));
        } else {
            mImageViewCheckIndicator.setVisibility(View.GONE);
            mLinearLayoutAddress.setBackgroundColor(Color.TRANSPARENT);
        }
        mTextViewLanguage.setText(language.second);
    }
}
