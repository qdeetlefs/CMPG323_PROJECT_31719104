package za.ac.nwu.ac.logic.flow.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModuloTest {

    private Modulo mod;

    @Before
    public void setUp() throws Exception {
        mod = new Modulo();
    }

    @Test()
    public void testModBy0(){
        try {
            Integer result =  mod.doMod(9, 0);
            fail("Should throw an exception");
        } catch (Exception e)
        {
            assertEquals("Some reason",e.getMessage());
        }

    }
}
