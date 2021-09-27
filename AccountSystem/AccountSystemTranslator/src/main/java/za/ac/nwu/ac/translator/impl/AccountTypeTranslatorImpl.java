package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            // TODO: Log
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountTypeDtos;

    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try {
            AccountType accountType = accountTypeRepository.save((accountTypeDto.getAccountType()));
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.deleteAccountType(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to delete from the database",e);
        }
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountType_name, LocalDate newCreationDate) {
        try {
            AccountType accountType = accountTypeRepository.updateAccountType(mnemonic, newAccountType_name, newCreationDate);
            return new AccountTypeDto(accountType);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to update row from the database",e);
        }
    }
}
