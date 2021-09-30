package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.config.TranslatorConfig;

import java.time.LocalDate;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionTranslatorImpl.class);

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

    @Override
    public AccountTransaction getAccountTransactionByMemberId(Long memberId) {
        try {
            return repo.findByMemberId(memberId);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public void addMiles(Long memberId, Long milesToAdd, LocalDate newTransactionDate) {
        try {
            repo.addMiles(memberId, milesToAdd, newTransactionDate);
        } catch (Exception e) {
            throw new RuntimeException("Unable to modify the DB", e);
        }
    }

    @Override
    public void subtractMiles(Long memberId, Long milesToSubtract, LocalDate newTransactionDate) {
        try {
            repo.subtractMiles(memberId, milesToSubtract, newTransactionDate);
        } catch (Exception e) {
            throw new RuntimeException("Unable to modify the DB", e);
        }
    }

    @Override
    public void addPoints(Long memberId, Long pointsToAdd, LocalDate newTransactionDate) {
        try {
            repo.addPoints(memberId, pointsToAdd, newTransactionDate);
        } catch (Exception e) {
            throw new RuntimeException("Unable to modify the DB", e);
        }
    }

    @Override
    public void subtractPoints(Long memberId, Long pointsToSubtract, LocalDate newTransactionDate) {
        try {
            repo.subtractPoints(memberId, pointsToSubtract, newTransactionDate);
        } catch (Exception e) {
            throw new RuntimeException("Unable to modify the DB", e);
        }
    }

}
