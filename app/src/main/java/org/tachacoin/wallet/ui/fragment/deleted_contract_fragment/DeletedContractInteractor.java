package org.tachacoin.wallet.ui.fragment.deleted_contract_fragment;


import org.tachacoin.wallet.model.contract.Contract;
import org.tachacoin.wallet.model.contract.Token;

import java.util.List;

public interface DeletedContractInteractor {

    List<Contract> getContractsWithoutTokens();

    List<Token> getTokens();

    void setContractWithoutTokens(List<Contract> contracts);

    void setTokens(List<Token> tokens);

}
