package org.tachacoin.wallet.ui.fragment.about_fragment;

public interface AboutInteractor {
    String getVersion() throws Exception;

    int getCodeVersion() throws Exception;
}
