package test;


import classes.Rubrica;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class RubricaTest {

    @BeforeEach
    public void setup() {
        Rubrica.crea ();
    }

    @AfterEach
    public void reset() {
        Rubrica.svuota ();
    }

    @Test
    public void testCreazione() {
        assertTrue(Rubrica.numEl() == 0);
    }

    @Test
    public void testSvuota() {
        Rubrica.svuota ();
        assertEquals (0, Rubrica.numEl());
    }

    @Test
    public void testAggiunta1() {
        assertEquals(1, Rubrica.add("Giovanni=1234567890"));
        assertEquals(1, Rubrica.add("Marco=1231231230"));
        assertEquals(1, Rubrica.add("Geremia=1029384756"));
        assertEquals(1, Rubrica.add("Raffaele=1234876509"));
        assertTrue(Rubrica.numEl() == 4);
    }
}
