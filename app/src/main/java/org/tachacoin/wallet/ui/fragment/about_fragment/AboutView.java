package org.tachacoin.wallet.ui.fragment.about_fragment;

import org.tachacoin.wallet.model.Version;
import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentView;

public interface AboutView extends BaseFragmentView {
    void updateVersion(Version version);
}
