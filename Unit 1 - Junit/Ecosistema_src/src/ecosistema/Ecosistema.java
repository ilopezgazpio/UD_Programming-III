package ecosistema;

import java.util.ArrayList;

/** Clase de datos de ecosistema, planteada para tener solo una instancia (patron Singleton).
 * @author
 */
public class Ecosistema
{
    private static Ecosistema ecoSistema = new Ecosistema();
    private ArrayList<...> listaElemsEcosistema;

    /** Constructor de ecosistema, vacio y privado (solo puede ejecutarse internamente, y solo se ejecuta una vez)
     */
    private Ecosistema()
    {

    }

    /** Recupera el unico ecosistema creado
     * @return	Devuelve el ecosistema
     */
    public static Ecosistema getMundo()
    {
        ...
    }

    /** Devuelve los elementos del ecosistema
     * @return	Lista de los elementos existentes
     */
    public ArrayList<ElementoEcosistema> getElementos()
    {
        ...
    }

    /** Metodo de calculo de distancia entre dos elementos del ecosistema
     * @param ee1	Elemento 1
     * @param ee2	Elemento 2
     * @return	Distancia lineal entre las coordenadas de los elementos
     */
    public static int distancia( ElementoEcosistema ee1, ElementoEcosistema ee2 )
    {
        return (int) (
                Math.sqrt(
                        Math.pow( ... )
                )
        );
    }
}
