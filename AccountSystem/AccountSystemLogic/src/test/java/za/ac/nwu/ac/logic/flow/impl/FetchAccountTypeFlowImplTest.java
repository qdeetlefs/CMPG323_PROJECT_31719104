package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FetchAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private FetchAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllAccountTypes() {

    }

    @Test
    public void getAccountTypeByMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("MILES", "Miles", LocalDate.now());



        //when(translator.getAccountTypeByMnemonic(Mockito.any())).then(AdditionalAnswers.returnsFirstArg());
        AccountTypeDto result = flow.getAccountTypeByMnemonic("MILES");
        assertNotNull(result);

    }

    @Test
    public void getAccountTypeDbEntityByMnemonic() {
    }


}