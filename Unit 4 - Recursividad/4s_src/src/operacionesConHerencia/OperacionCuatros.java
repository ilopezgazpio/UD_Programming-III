package operacionesConHerencia;

/** Clase que modela cada una de las posibles operaciones realizadas con cuatros
 * (con cualquier numero de cuatros, de 1 a 4). <p>
 * Por ejemplo la operacion mas sencilla: 4     (un solo cuatro) <p>
 * Otro ejemplo de operacion mas compleja: ((4 / 4) * (4 + 4))    (cuatro cuatros)
 * @author andoni
 */
public class OperacionCuatros extends Operacion
{
    /**
     * Numero de cuatros de la operacion (de 1 a 4)
     */
    private int numCuatros;

    /**
     *  Crea una operacion basica con solo un operando: 4
     */
    public OperacionCuatros( )
    {
        super(4);
        numCuatros = 1;
    }

    /** Crea una operacion partiendo de dos operaciones existentes y un operador
     * @param o1	operacionesConHerencia.Operacion 1 valida (operando izquierdo)
     * @param operador	Operador que se aplica: '+', '-', '*' o '/'
     * @param o2	operacionesConHerencia.Operacion 2 valida (operando derecho)
     * No construir esta operacion con el operador de division, cuando la operacion 2 (o2) sea cero
     * (error aritmetico)
     */
    public OperacionCuatros( OperacionCuatros o1, char operador, OperacionCuatros o2 )
    {
        setToResOperacionBinaria( ... );
        numCuatros = ...
    }

    /**  Consultor del numero de cuatros de la operacion
     * @return Numero de cuatros (de 1 a 4)
     */
    public int getNumCuatros()
    {
        ...
    }

    /** Programa principal de prueba de la clase
     * @param s   Array de parametros - no utilizado
     */
    public static void main (String s[])
    {
        OperacionCuatros o1 = new OperacionCuatros();
        OperacionCuatros o2 = new OperacionCuatros( o1, '+', o1 );
        OperacionCuatros o3 = new OperacionCuatros( o2, '/', o1 );
        OperacionCuatros o4 = new OperacionCuatros( o3, '*', o1 );

        System.out.println( "Creando operacion 4         ---> " + o1 );
        System.out.println( "Creando operacion 4+4       ---> " + o2 );
        System.out.println( "Creando operacion (4+4)/4   ---> " + o3 );
        System.out.println( "Creando operacion (4+4)/4*4 ---> " + o4 );
        System.out.println( "  De esta operacion. Valor = " + o4.getValor() + " -- " +
                "Numero de cuatros = " + o4.getNumCuatros() + " -- Representacion = " + '"' + o4.getOperacion() + '"' );
        System.out.println( "Numero de operaciones distintas creadas internamente: " + getNumOperacionesCreadas() );
    }
}
