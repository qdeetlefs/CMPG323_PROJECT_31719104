package za.ac.nwu.ac.domain.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTransactionDtoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void buildAccountTransaction() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getTransactionId());
    }
}