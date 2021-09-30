package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTransactionFlowImpl implements ModifyAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslator accountTransactionTranslator;

    public ModifyAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto addMiles(Long memberId, Long milesToAdd, LocalDate newTransactionDate, boolean optionalException) {

        if (null == newTransactionDate) {
            newTransactionDate = LocalDate.now();
        }

        LOGGER.info("The optionalException value was {}", optionalException);

        if (optionalException){
            throw new RuntimeException("Transaction Rollback");
        }

        LOGGER.info("The original value was {}", accountTransactionTranslator.getAccountTransactionByMemberId(memberId));

        accountTransactionTranslator.addMiles(memberId, milesToAdd,newTransactionDate);


        return null; //ADD RETURN ARGUMENTS
    }

    @Override
    public AccountTransactionDto subtractMiles(Long memberId, Long milesToSubtract, LocalDate newTransactionDate) {
        if (null == newTransactionDate) {
            newTransactionDate = LocalDate.now();
        }
        accountTransactionTranslator.subtractMiles(memberId, milesToSubtract,newTransactionDate);
        return null; //ADD RETURN ARGUMENTS
    }

    @Override
    public AccountTransactionDto addPoints(Long memberId, Long pointsToAdd, LocalDate newTransactionDate) {
        if (null == newTransactionDate) {
            newTransactionDate = LocalDate.now();
        }
        accountTransactionTranslator.addPoints(memberId, pointsToAdd,newTransactionDate);

        return null;
    }

    @Override
    public AccountTransactionDto subtractPoints(Long memberId, Long pointsToSubtract, LocalDate newTransactionDate) {
        if (null == newTransactionDate) {
            newTransactionDate = LocalDate.now();
        }
        accountTransactionTranslator.subtractPoints(memberId, pointsToSubtract,newTransactionDate);
        return null;
    }
}
