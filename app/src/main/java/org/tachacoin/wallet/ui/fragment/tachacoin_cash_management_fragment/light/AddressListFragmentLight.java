package org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment.light;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import org.tachacoin.wallet.R;
import org.tachacoin.wallet.model.AddressWithBalance;
import org.tachacoin.wallet.model.gson.UnspentOutput;
import org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment.AddressListFragment;
import org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment.AddressesWithBalanceAdapter;
import org.tachacoin.wallet.ui.fragment.tachacoin_cash_management_fragment.AddressesWithBalanceSpinnerAdapter;
import org.tachacoin.wallet.utils.FontTextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AddressListFragmentLight extends AddressListFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_address_list_light;
    }

    @Override
    public void updateAddressList(List<AddressWithBalance> deterministicKeys) {
        mAddressesWithBalanceAdapter = new AddressesWithBalanceAdapter(deterministicKeys, this, R.layout.item_address_light);
        mRecyclerView.setAdapter(mAddressesWithBalanceAdapter);
    }

    @Override
    public void onItemClick(AddressWithBalance deterministicKeyWithBalance) {
        List<AddressWithBalance> deterministicKeyWithBalances = new ArrayList<>(getPresenter().getAddressWithBalanceList());
        deterministicKeyWithBalances.remove(deterministicKeyWithBalance);
        showTransferDialogFragment(deterministicKeyWithBalance, deterministicKeyWithBalances);
    }

    protected void showTransferDialogFragment(final AddressWithBalance keyWithBalanceTo, List<AddressWithBalance> keyWithBalanceList) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_transfer_balance_fragment_light, null);
        final TextInputEditText mEditTextAmount = (TextInputEditText) view.findViewById(R.id.et_amount);
        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner_transfer);
        FontTextView mEditTextAddressTo = (FontTextView) view.findViewById(R.id.tv_address_to);
        final FontTextView tvBalanceFrom = (FontTextView) view.findViewById(R.id.balance_from_tv);

        mEditTextAddressTo.setText(keyWithBalanceTo.getAddress());
        AddressesWithBalanceSpinnerAdapter spinnerAdapter = new AddressesWithBalanceSpinnerAdapterLight(getContext(), keyWithBalanceList);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                AddressWithBalance item = (AddressWithBalance) spinner.getItemAtPosition(i);
                getPresenter().setKeyWithBalanceFrom(item);

                BigDecimal balance = new BigDecimal("0");
                BigDecimal amount;
                for (UnspentOutput unspentOutput : item.getUnspentOutputList()) {
                    amount = new BigDecimal(String.valueOf(unspentOutput.getAmount()));
                    balance = balance.add(amount);
                }

                tvBalanceFrom.setText(String.format("%s TACHACOIN", balance.toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        view.findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTransferDialog.dismiss();
            }
        });

        view.findViewById(R.id.bt_transfer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressDialog();
                transfer(keyWithBalanceTo, getPresenter().getKeyWithBalanceFrom(), mEditTextAmount.getText().toString());
            }
        });

        mTransferDialog = new AlertDialog
                .Builder(getContext())
                .setView(view)
                .create();

        if (mTransferDialog.getWindow() != null) {
            mTransferDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        mTransferDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                showTransferDialog = false;
            }
        });

        mTransferDialog.setCanceledOnTouchOutside(false);
        mTransferDialog.show();
    }
}
