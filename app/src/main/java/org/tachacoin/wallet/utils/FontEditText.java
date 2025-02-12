package org.tachacoin.wallet.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

import org.tachacoin.wallet.R;

public class FontEditText extends android.support.v7.widget.AppCompatEditText {
    public FontEditText(Context context) {
        this(context, null);
    }

    public FontEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode())
            return;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontEditText);

        if (ta != null) {
            String fontAsset = ta.getString(R.styleable.FontEditText_editTextTypeface);

            if (!TextUtils.isEmpty(fontAsset)) {
                Typeface tf = FontManager.getInstance().getFont(fontAsset);
                int style = Typeface.NORMAL;

                if (getTypeface() != null)
                    style = getTypeface().getStyle();

                if (tf != null)
                    setTypeface(tf, style);
                else
                    Log.d("FontText", String.format("Could not create a font from asset: %s", fontAsset));
            }
        }
    }
}