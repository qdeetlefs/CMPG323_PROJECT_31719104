package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyAccountTypeFlowImpl.class);

    private final AccountTypeTranslator accountTypeTranslator;

    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        accountTypeTranslator.deleteAccountType(mnemonic);
        return new AccountTypeDto("DELETED","Deleted",null);
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountType_Name, LocalDate newCreationDate) {

        if (null == newCreationDate) {
            newCreationDate = LocalDate.now();
        }

        accountTypeTranslator.updateAccountType(mnemonic, newAccountType_Name, newCreationDate);

        return new AccountTypeDto(mnemonic,newAccountType_Name,newCreationDate);
    }
}
