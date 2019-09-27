package testString;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static string.MyString.quitarTabsYSaltosLinea;
import static string.MyString.wrapString;

public class testMyString
{

    private static String test1;
    private static String test2;
    private static String test3;
    private static String test4;
    private static String test5;

    @Before
    public void setUp() throws Exception
    {
        test1 = "Hola\nEsto es un string con tres lineas\ny\tvarios\ttabuladores.";
        test2 = "Esto solo tiene\ttabs";
        test3 = "Y esto no tiene lineas ni tabuladores";
        test4 = "";
        test5 = null;
    }

    @After
    public void tearDown() throws Exception
    {
        // En este caso no hay nada que "limpiar"
    }

    @Test
    public void testQuitarTabsYSaltosLinea()
    {
        assertEquals( "Hola#Esto es un string con tres lineas#y|varios|tabuladores.", quitarTabsYSaltosLinea( test1 ));
        assertEquals( "Esto solo tiene|tabs", quitarTabsYSaltosLinea( test2 ));
        assertEquals( "Y esto no tiene lineas ni tabuladores", quitarTabsYSaltosLinea( test3 ));
        assertEquals( "", quitarTabsYSaltosLinea( test4 ));
        assertEquals( null, quitarTabsYSaltosLinea( test5 ));
    }

    @Test
    public void testWrapString()
    {
        assertEquals( "Hol...", wrapString( test1, 3 ) );
        assertEquals( "Hola\nEsto ...", wrapString( test1, 10 ) );
        assertEquals( "Esto solo tiene\ttabs", wrapString( test2, 20) );
        assertEquals( "Esto solo tiene\ttabs", wrapString( test2, 21) );
        assertEquals( "Esto solo tiene\ttab...", wrapString( test2, 19) );
        assertEquals( "...", wrapString( test2, 0) );
        assertEquals( "", wrapString( test4, 40) );
        assertEquals( null, wrapString( null, 5 ) );
    }

    @Test
    public void test3()
    {
        // Manera 1 de chequear excepciones
        try
        {
            // Encontrado IndexOutOfBounds si se pasa un negativo -> Anadido a especificacion del metodo:
            wrapString( test4, -5);
            // * @throws IndexOutOfBoundsException	Si largo es negativo
            fail( "Error - deberia generar IndexOutOfBounds" );
        } catch (IndexOutOfBoundsException e)
        {

        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWrapStringException()
    {
        // Manera 2 de chequear excepciones  (usar cualquiera de las dos, se indican las dos para conocerlas, pero no tiene sentido duplicar el mismo test)
        wrapString( test4, -5 );
    }

    @Test
    public void testWrapYQuitar()
    {  // Test conjunto de los dos metodos (a veces es interesante probar varios metodos interactuando entre si)
        assertEquals( "Hola#Esto ...", wrapString( quitarTabsYSaltosLinea(test1), 10 ) );
        assertEquals( "Hola#Esto ...", quitarTabsYSaltosLinea( wrapString(test1,10) ) );
    }

}
