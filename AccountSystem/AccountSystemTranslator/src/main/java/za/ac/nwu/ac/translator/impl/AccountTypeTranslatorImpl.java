package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {


    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeTranslatorImpl.class);

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
    public void deleteAccountType(String mnemonic) {
        try {
            accountTypeRepository.deleteAccountType(mnemonic);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to delete from the database",e);
        }
    }

    @Override
    public void updateAccountType(String mnemonic, String newAccountType_name, LocalDate newCreationDate) {
        try {
            accountTypeRepository.updateAccountType(mnemonic, newAccountType_name, newCreationDate);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to update row from the database",e);
        }
    }

    @Override
    public AccountType getAccountTypeDbEntityByMnemonic(String accountTypeMnemonic) {
        try {
            return accountTypeRepository.getAccountTypeDbEntityByMnemonic(accountTypeMnemonic);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }
}
