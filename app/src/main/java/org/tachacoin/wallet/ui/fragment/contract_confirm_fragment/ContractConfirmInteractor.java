package org.tachacoin.wallet.ui.fragment.contract_confirm_fragment;

import org.tachacoin.wallet.model.TransactionHashWithSender;
import org.tachacoin.wallet.model.contract.ContractMethodParameter;
import org.tachacoin.wallet.model.gson.SendRawTransactionRequest;
import org.tachacoin.wallet.model.gson.SendRawTransactionResponse;
import org.tachacoin.wallet.model.gson.UnspentOutput;

import java.math.BigDecimal;
import java.util.List;

import rx.Observable;

public interface ContractConfirmInteractor {
    Observable<String> createAbiConstructParams(List<ContractMethodParameter> contractMethodParameterList, String uiid);

    Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses();

    Observable<SendRawTransactionResponse> sendRawTransaction(SendRawTransactionRequest sendRawTransactionRequest);

    void saveContract(String txid, String contractTemplateUiid, String contractName, String senderAddress);

    TransactionHashWithSender createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, String fee, String passphrase);

    BigDecimal getFeePerKb();

    int getMinGasPrice();
}
