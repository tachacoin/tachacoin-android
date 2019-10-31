package org.tachacoin.wallet.ui.fragment.smart_contracts_fragment.light;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.ui.fragment.profile_fragment.SettingObject;
import org.tachacoin.wallet.ui.fragment.smart_contracts_fragment.SmartContractsFragment;

import java.util.ArrayList;
import java.util.List;

public class SmartContractsFragmentLight extends SmartContractsFragment {

    private List<SettingObject> settingsData;

    @Override
    protected int getLayout() {
        return org.tachacoin.wallet.R.layout.fragment_smart_contracts_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        settingsData = new ArrayList<>();
        settingsData.add(new SettingObject(org.tachacoin.wallet.R.string.my_new_contracts, org.tachacoin.wallet.R.drawable.ic_my_new_contracts_light, 0));
        settingsData.add(new SettingObject(org.tachacoin.wallet.R.string.my_published_contracts, org.tachacoin.wallet.R.drawable.ic_my_published_contracts_light, 0));
        //settingsData.add(new SettingObject(R.string.contracts_store, R.drawable.tachacoin_logo, 0));
        settingsData.add(new SettingObject(org.tachacoin.wallet.R.string.watch_contract, org.tachacoin.wallet.R.drawable.ic_contr_watch_light, 0));
        settingsData.add(new SettingObject(org.tachacoin.wallet.R.string.watch_token, org.tachacoin.wallet.R.drawable.ic_token_watch_light, 0));
        settingsData.add(new SettingObject(org.tachacoin.wallet.R.string.backup_contracts, org.tachacoin.wallet.R.drawable.ic_contract_backup_light, 0));
        settingsData.add(new SettingObject(org.tachacoin.wallet.R.string.restore_contracts, org.tachacoin.wallet.R.drawable.ic_contract_restore_light, 0));
        initializeList(org.tachacoin.wallet.R.layout.lyt_profile_pref_list_item_light, org.tachacoin.wallet.R.drawable.color_primary_divider_light, org.tachacoin.wallet.R.drawable.section_setting_divider_light, settingsData);
    }
}
