package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTransactionDetailsTranslator;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTransactionDetailsTranslator accountTransactionDetailsTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;


    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator, AccountTransactionDetailsTranslator accountTransactionDetailsTranslator, FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTransactionDetailsTranslator = accountTransactionDetailsTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto  accountTransactionDto) {
        accountTransactionDto.setTransactionId(); //in case it was populated

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        if (null != accountTransactionDto.getDetails()) {
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails().buildAccountTransactionDetails(accountTransaction);
            accountTransaction.setDetails(accountTransactionDetails);
        }

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        return new AccountTransactionDto(createdAccountTransaction);
    }


}
