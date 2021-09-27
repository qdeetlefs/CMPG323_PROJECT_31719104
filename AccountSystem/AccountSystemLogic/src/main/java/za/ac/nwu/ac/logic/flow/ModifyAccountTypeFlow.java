package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;

public interface ModifyAccountTypeFlow {
    AccountTypeDto deleteAccountType(String mnemonic);

    Object updateAccountType(String anyString, String anyString1, LocalDate any);
}
