package string;


/** Utilidades de Strings de ejemplo
 * Clase preparada para hacer con ella pruebas unitarias con JUnit
 * @author Andoni Eguiluz Moran
 * Facultad de Ingenieria - Universidad de Deusto
 */
public class MyString
{

    /** Devuelve cualquier string sin saltos de linea ni tabuladores (para poder exportarlo de forma tabular sin conflicto)
     * @param s	String con cualquier contenido
     * @return	Mismo string sustituyendo \t con el caracter | y \n con el caracter #; Devuelve null si s es null.
     */
    public static String quitarTabsYSaltosLinea( String s )
    {
        if (s==null) return null;
        return s.replaceAll( "\n", "#" ).replaceAll( "\t", "|" );
    }

    /** Devuelve cualquier string truncado al numero de caracteres indicado, con puntos suspensivos al final si se ha truncado
     * @param s	String con cualquier contenido o null
     * @param largo	Numero maximo de caracteres de longitud
     * @return	String recortado si ocupaba mas de largo caracteres con tres puntos suspensivos al final; mismo string en caso contrario; null si s es null.
     */
    public static String wrapString( String s, int largo )
    {
        if (s==null)
            return null;
        else if (s.length() > largo)
            return s.substring(0, largo) + "...";
        else
            return s;
    }


    public static void main(String[] args)
    {

        // Prueba convencional (no estructurada, no exhaustiva, no automatizable)
        String prueba = "Hola\nEsto es un string con tres lineas\ny\tvarios\ttabuladores.";

        System.out.println( prueba );
        System.out.println( quitarTabsYSaltosLinea( prueba ));
        System.out.println( wrapString( prueba, 3 ) );
        System.out.println( wrapString( prueba, 10 ) );
        System.out.println( wrapString( quitarTabsYSaltosLinea(prueba), 10 ) );

    }


}
