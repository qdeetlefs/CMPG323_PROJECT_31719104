package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.AdditionalAnswers;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
//        translator = Mockito.mock(AccountTypeTranslator.class); //hard way to mock
//        flow = new CreateAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

        AccountTypeDto accountTypeDto = new AccountTypeDto(null,null,LocalDate.now());

        Mockito.when(translator.create(Mockito.any(AccountTypeDto.class))).then(AdditionalAnswers.returnsFirstArg());
        AccountTypeDto result = flow.create(new AccountTypeDto());
        assertNotNull(result);
        assertEquals(LocalDate.now(), result.getCreationDate());
        Mockito.verify(translator, Mockito.times(1)).create(Mockito.eq(accountTypeDto));
    }
}