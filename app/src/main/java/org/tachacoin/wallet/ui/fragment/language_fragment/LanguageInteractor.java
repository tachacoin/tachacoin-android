package org.tachacoin.wallet.ui.fragment.language_fragment;

import android.util.Pair;

import org.tachacoin.wallet.datastorage.listeners.LanguageChangeListener;

import java.util.List;

public interface LanguageInteractor {
    String getLanguage();

    void setLanguage(String language);

    List<Pair<String, String>> getLanguagesList();

    void removeLanguageListener(LanguageChangeListener languageChangeListener);

    void addLanguageListener(LanguageChangeListener languageChangeListener);
}
