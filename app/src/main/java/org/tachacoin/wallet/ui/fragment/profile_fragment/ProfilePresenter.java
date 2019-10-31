package org.tachacoin.wallet.ui.fragment.profile_fragment;

import org.tachacoin.wallet.datastorage.listeners.LanguageChangeListener;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface ProfilePresenter extends BaseFragmentPresenter {
    void onTouchIdSwitched(boolean isChecked);

    void clearWallet();

    List<SettingObject> getSettingsData();

    void setupLanguageChangeListener(LanguageChangeListener listener);

    void removeLanguageListener(LanguageChangeListener listener);
}
