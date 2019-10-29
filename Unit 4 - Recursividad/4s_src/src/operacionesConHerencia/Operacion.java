package operacionesConHerencia;

/** Clase que modela una operacion cualesquiera
 * Por ejemplo la operacion mas sencilla: 3
 * Otro ejemplo de operacion mas compleja: ((2 / 3) * (17 + 1))
 * @author andoni
 */
public class Operacion
{

    /**
     * Representacion textual de la operacion
     */
    protected String operacion;

    /**
     * Valor resultado de la operacion (float al poderse incluir divisiones)
     */
    protected float valor;

    /**
     * Contador de operaciones
     */
    static private int numOperacionesCreadas = 0;

    /**
     * Crea una operacion basica vacia
     */
    public Operacion( )
    {
        numOperacionesCreadas++;
        operacion = "";
        valor = 0;
    }

    /**
     *  Crea una operacion basica con solo un operando
     */
    public Operacion( int operando )
    {
        numOperacionesCreadas++;
        operacion = "" + operando;
        valor = operando;
    }

    /** Crea una operacion partiendo de dos operaciones existentes y un operador
     * @param o1	operacionesConHerencia.Operacion 1 valida
     * @param operador	Operador que se aplica: '+', '-', '*' o '/'
     * @param o2	operacionesConHerencia.Operacion 2 valida
     * No construir esta operacion con el operador de division, cuando la operacion 2 (o2) sea cero
     * (error aritmetico)
     */
    // (observese como llama al metodo de INSTANCIA calculaOperacionBinaria
    // que SI se hereda, para usarlo en clases hijas)
    public Operacion( Operacion o1, char operador, Operacion o2 )
    {
        numOperacionesCreadas++;
        setToResOperacionBinaria( ... );
    }

    /** Modifica el objeto operacion al resultado de la operacion binaria o1 operador o2
     * El valor que tuviera el objeto <this> no se usa, y se pierde tras ejecutar este metodo
     * @param o1	operacion operando izquierdo
     * @param operador	operador '+', '-', '*' o '/'
     * @param o2	operacion operando derecho
     */
    protected void setToResOperacionBinaria( Operacion o1, char operador, Operacion o2 )
    {
        operacion = "(" + o1.operacion + " " + operador + " " + o2.operacion + ")";
        switch (operador) {
            case '+':
                ...
                break;
            case '-':
                ...
                break;
            case '*':
                ...
                break;
            case '/':
                ...
                break;
            default:
                ...
        }
    }

    /**  Consultor del valor de la operacion
     * @return Valor numerico
     */
    public float getValor()
    {
        ...
    }

    /**  Consultor de la representacion textual de la operacion
     * @return Representacion en String de la operacion
     */
    public String getOperacion()
    {
        ...
    }

    /* Conversion a string de la operacion con el formato:
     * valor = operacion
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return getValor() + " = " + getOperacion();
	// Si se quiere redondear a entero:
	// return Math.round(getValor()) + " = " + getOperacion();
    }

    /*
     * @see java.lang.Object#toString()
     */
    /** Conversion a string de la operacion. Si el parametro es false, con el formato:<p>
     * valor = operacion<p>
     *  Y si el parametro es true, con el formato:<p>
     *  operacion<p>
     * @param reducido	Formato ampliado (false) o reducido (true)
     * @return
     */
    public String toString( boolean reducido )
    {
        if (reducido) return getOperacion(); else return toString();
        // Si se quiere redondear a entero:
        // return Math.round(getValor()) + " = " + getOperacion();
    }

    /** Consultor del numero de operaciones creadas
     * @return	Numero de operaciones creadas desde el inicio del programa
     */
    static int getNumOperacionesCreadas()
    {
        ...
    }

    /** Programa principal de prueba de la clase
     * @param s   Array de parametros - no utilizado
     */
    public static void main (String s[])
    {
        Operacion o1 = new Operacion( 7 );
        Operacion o2 = new Operacion( o1, '+', new Operacion( 3 ) );
        Operacion o3 = new Operacion( o2, '/', o1 );
        Operacion o4 = new Operacion( o3, '*', new Operacion( 3 ) );

        System.out.println( "Creando operacion 7         ---> " + o1 );
        System.out.println( "Creando operacion 7+3       ---> " + o2 );
        System.out.println( "Creando operacion (7+3)/7   ---> " + o3 );
        System.out.println( "Creando operacion (7+3)/7*3 ---> " + o4 );
        System.out.println( "  De esta operacion. Valor = " + o4.getValor() + " -- " +
                " -- Representacion = " + '"' + o4.getOperacion() + '"' );
        System.out.println( "Numero de operaciones distintas creadas internamente: " + getNumOperacionesCreadas() );
    }
}
