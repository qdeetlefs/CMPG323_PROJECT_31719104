package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTransactionFlowImpl.class);

    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator){ this.translator = translator; }

    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionId);
        return null != accountTransaction ? new AccountTransactionDto(accountTransaction): null;
    }

    @Override
    public AccountTransactionDto getAccountTransactionByMemberId(Long memberId) {

        LOGGER.info("The input memberId was {}", memberId);

        AccountTransaction accountTransaction = translator.getAccountTransactionByMemberId(memberId);

        LOGGER.info("Got AccountType for {} and the TransactionId is {}", accountTransaction.getAccountType(), accountTransaction.getTransactionId());


        return null != accountTransaction ? new AccountTransactionDto(accountTransaction): null;
    }
}
