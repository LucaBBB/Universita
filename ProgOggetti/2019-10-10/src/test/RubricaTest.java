package test;


import classes.Rubrica;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RubricaTest {

    @Test
    public void testCreazione() {
        Rubrica.crea();
        assertEquals(0, Rubrica.numEl());
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
        assertEquals(1, Rubrica.remove("Gio"));
        assertEquals(3, Rubrica.numEl());
        ArrayList<String> trovati = Rubrica.findByString("Luc");
        assertEquals(0, trovati.size());
    }
}
