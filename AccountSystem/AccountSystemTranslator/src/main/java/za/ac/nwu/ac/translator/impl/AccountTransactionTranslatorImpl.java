package za.ac.nwu.ac.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try {
            return repo.save(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {
        try {
            return repo.findById(transactionId).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

}
