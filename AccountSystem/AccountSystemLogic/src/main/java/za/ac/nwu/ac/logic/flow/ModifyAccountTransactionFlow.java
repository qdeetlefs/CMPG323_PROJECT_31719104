package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

public interface ModifyAccountTransactionFlow {
    AccountTransactionDto addMiles(Long memberId, Long milesToAdd);
}
