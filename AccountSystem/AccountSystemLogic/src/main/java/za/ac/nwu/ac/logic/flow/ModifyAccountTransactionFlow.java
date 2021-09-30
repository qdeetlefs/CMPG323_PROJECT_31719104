package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.time.LocalDate;

public interface ModifyAccountTransactionFlow {
    AccountTransactionDto addMiles(Long memberId, Long milesToAdd, LocalDate newTransactionDate, boolean optionalException);

    AccountTransactionDto subtractMiles(Long memberId, Long milesToSubtract, LocalDate newTransactionDate);

    AccountTransactionDto addPoints(Long memberId, Long pointsToAdd, LocalDate newTransactionDate);

    AccountTransactionDto subtractPoints(Long memberId, Long pointsToSubtract, LocalDate newTransactionDate);
}
