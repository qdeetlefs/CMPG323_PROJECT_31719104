package za.ac.nwu.ac.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountTransactionControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        String expectedResponse = "{\"payload\":[" +
                "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles account type\",\"creationDate\":[2020,1,1]}," +
                "{\"mnemonic\":\"PLAY\",\"accountTypeName\":\"Play account type\",\"creationDate\":[2021,4,1]}]}";

        List<AccountTypeDto> accountTypes = new ArrayList<>();
        accountTypes.add(new AccountTypeDto("MILES", "Miles account type", LocalDate.parse("2020-01-01")));
        accountTypes.add(new AccountTypeDto("PLAY", "Play account type", LocalDate.parse("2021-04-01")));

    }
}