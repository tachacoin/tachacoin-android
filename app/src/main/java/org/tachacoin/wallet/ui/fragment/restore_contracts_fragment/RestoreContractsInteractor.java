package org.tachacoin.wallet.ui.fragment.restore_contracts_fragment;

import org.tachacoin.wallet.model.ContractTemplate;
import org.tachacoin.wallet.model.backup.Backup;
import org.tachacoin.wallet.model.backup.ContractJSON;
import org.tachacoin.wallet.model.backup.TemplateJSON;
import org.tachacoin.wallet.model.contract.Contract;
import org.tachacoin.wallet.model.contract.Token;

import java.io.File;
import java.util.List;

public interface RestoreContractsInteractor {
    Backup getBackupFromFile(File restoreFile) throws Exception;

    List<ContractTemplate> getContractTemplates();

    ContractTemplate importTemplate(TemplateJSON templateJSON, List<ContractTemplate> templates);

    void putListWithoutToken(List<Contract> contractList);

    void putTokenList(List<Token> tokenList);

    boolean validateContractCreationAddress(ContractJSON contractJSON, List<TemplateJSON> templates);

    boolean getTemplateValidity(TemplateJSON templateJSON);

    boolean getContractValidity(ContractJSON contractJSON);
}
