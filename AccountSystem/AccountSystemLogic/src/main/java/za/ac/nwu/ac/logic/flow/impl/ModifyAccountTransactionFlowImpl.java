package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTransactionFlowImpl implements ModifyAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public ModifyAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto addMiles(Long memberId, Long milesToAdd, LocalDate newTransactionDate) {

        if (null == newTransactionDate) {
            newTransactionDate = LocalDate.now();
        }
        accountTransactionTranslator.addMiles(memberId, milesToAdd,newTransactionDate);
        return new AccountTransactionDto(); //ADD RETURN ARGUMENTS
    }

    @Override
    public AccountTransactionDto subtractMiles(Long memberId, Long milesToSubtract, LocalDate newTransactionDate) {
        if (null == newTransactionDate) {
            newTransactionDate = LocalDate.now();
        }
        accountTransactionTranslator.subtractMiles(memberId, milesToSubtract,newTransactionDate);
        return new AccountTransactionDto(); //ADD RETURN ARGUMENTS
    }
}
