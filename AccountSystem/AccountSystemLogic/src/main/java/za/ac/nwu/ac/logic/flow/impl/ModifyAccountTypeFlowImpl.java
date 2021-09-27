package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        return accountTypeTranslator.deleteAccountType(mnemonic);
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountType_Name, LocalDate newCreationDate) {
        return accountTypeTranslator.updateAccountType(mnemonic, newAccountType_Name, newCreationDate);
    }
}
