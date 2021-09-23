package test;

import LogicaDatos.Persona;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonaTest {

    Persona persona1;

    @Before
    public void setUp() {
        persona1 = new Persona();
    }

    @After
    public void tearDown() {
        persona1 = null;
    }

    @Test
    public void getNombreTest() {
        String nombre = "Smith";

        persona1.setNombre(nombre);
        assert (persona1.getNombre().equals(nombre));
    }

    @Test
    public void setNombreTest() {
        String nombre = "Smith";

        persona1.setNombre("Eve");
        assertFalse(persona1.getNombre().equals(nombre));

        // Es este test correcto ? es util ?
    }


    @Test
    public void mayorDeEdadTest() throws Exception {
        persona1.setEdad(15);
        assertFalse(persona1.mayorEdad());

        persona1.setEdad(16);
        assertFalse(persona1.mayorEdad());

        persona1.setEdad(17);
        assertFalse(persona1.mayorEdad());

        persona1.setEdad(18);
        assertTrue(persona1.mayorEdad());
        assertEquals(persona1.mayorEdad(), true);

        persona1.setEdad(20);
        assertTrue(persona1.mayorEdad());
        assertEquals(persona1.mayorEdad(), true);
    }


    @Test(expected = Exception.class)
    public void mayorDeEdad_Exception_Test() throws Exception {
        persona1.mayorEdad();
    }

    @Test
    public void mayorDeEdad_Exception_Test2() throws Exception {
        try {
            persona1.mayorEdad();
            fail();
        } catch(Exception e) {
            assertTrue(true);
        }

    }
}