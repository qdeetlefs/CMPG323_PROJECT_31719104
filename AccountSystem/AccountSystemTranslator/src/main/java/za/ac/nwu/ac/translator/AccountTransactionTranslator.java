package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.time.LocalDate;

public interface AccountTransactionTranslator {
    AccountTransaction save(AccountTransaction accountTransaction);

    AccountTransaction getAccountTransactionByPk(Long transactionId);

    AccountTransaction getAccountTransactionByMemberId(Long memberId);

    void addMiles(Long memberId, Long milesToAdd, LocalDate newTransactionDate);

    void subtractMiles(Long memberId, Long milesToSubtract, LocalDate newTransactionDate);

    void addPoints(Long memberId, Long pointsToAdd, LocalDate newTransactionDate);

    void subtractPoints(Long memberId, Long pointsToSubtract, LocalDate newTransactionDate);
}
