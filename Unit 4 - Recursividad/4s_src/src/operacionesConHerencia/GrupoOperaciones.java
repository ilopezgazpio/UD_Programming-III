package operacionesConHerencia;

import java.util.Vector;

/** Clase para agrupar operaciones
 * Cada uno de los objetos que se crea permitira agrupar cualquier numero de operaciones.
 * El almacen de operaciones es secuencial (se van guardando una detras de otra con el metodo anyadirOperacion)
 * El acceso a las operaciones introducidas es por posicion, de 0 a n-1 (como si fuera un array)
 * @author andoni
 */
public class GrupoOperaciones
{
    // Unico atributo: vector para almacenar operaciones
    private Vector<...> grupo;

    /** Crea un grupo vacio
     */
    public GrupoOperaciones()
    {
        grupo = new Vector<...>();
    }

    /** Anade una operacion al final de ese grupo
     * @param o operacionesConHerencia.Operacion a anadir
     */
    public void anyadirOperacion( ... o )
    {
        grupo.add( o );
    }

    /** Devuelve la operacion situada en la posicion numOp
     * @param numOp  Posicion de la operacion, entre 0 y tamanyo()-1
     * @return	operacionesConHerencia.Operacion devuelta
     */
    public Operacion cogerOperacion(int numOp )
    {
        ...
    }

    /** Devuelve un vector -iterable- correspondiente a todas las operaciones almacenadas
     * @return	Vector de operaciones completo
     */
    public Vector<...> getVector()
    {
        ...
    }

    /** Devuelve el numero de operaciones almacenadas (0 si el grupo esta vacio)
     * @return
     */
    public int tamanyo()
    {
        ...
    }

    /** Visualiza las operaciones guardadas en el grupo
     */
    public void visualizar()
    {
        int count = 0;
        for (Operacion o : grupo)
        {
            System.out.println( "  " + ++count + ": " + o.toString() );
        }
    }

    public String toString()
    {
        String res = "{ ";
        for (Operacion o : grupo)
        {
            res = res + o.toString( true ) + " ";
        }
        return res+"}";
    }

    /** Programa principal de prueba de la clase
     * @param s   Array de parametros - no utilizado
     */
    public static void main (String s[])
    {
        GrupoOperaciones g1 = new GrupoOperaciones();
        Operacion o1 = new Operacion( 2 );
        Operacion o2 = new Operacion( o1, '+', new Operacion(7) );

        g1.anyadirOperacion( o1 );
        g1.anyadirOperacion( new Operacion( o2, '/', new Operacion(3) ) );
        g1.anyadirOperacion( o2 );
        System.out.println( "Grupo de operaciones 1 contiene:" );

        g1.visualizar();
        System.out.println( "La operacion de la posicion 1 es: " + g1.cogerOperacion( 1 ));

        GrupoOperaciones g2 = new GrupoOperaciones();
        g2.anyadirOperacion( o1 );
        g2.anyadirOperacion( new Operacion() );
        System.out.println( "Grupo de operaciones 2 contiene:" );
        g2.visualizar();
    }

}
