package org.tachacoin.wallet.ui.fragment.restore_contracts_fragment;

import org.tachacoin.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import rx.Observable;

public interface RestoreContractsPresenter extends BaseFragmentPresenter {
    void onDeleteFileClick();

    void onRestoreClick(boolean restoreTemplates, boolean restoreContracts, boolean restoreTokens);

    Observable<Boolean> createBackupData();
}
