package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;

public interface AccountTransactionTranslator {
    AccountTransaction save(AccountTransaction accountTransaction);

    AccountTransaction getAccountTransactionByPk(Long transactionId);

    AccountTransaction getAccountTransactionByMemberId(Long memberId);

    void addMiles(Long memberId, Long milesToAdd);
}
