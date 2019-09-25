package ecosistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** Clase para instanciar elementos de ecosistema de tipo abejas
 * @author
 */
public class ColoniaAbejas extends ElementoEcosistema implements Evolucionable
{


    /** Constructor de colmena de abejas. La inicializa con una poblacion = raiz cuadrada de anchura * altura
     * @param titulo	Titulo (nombre)
     * @param x	Coordenada x
     * @param y	Coordenada y
     * @param anch	Anchura (en pixels)
     * @param alt	Altura (en pixels)
     */
    public ColoniaAbejas( String titulo, int x, int y, int anch, int alt )
    {
		...
    }

    /** Devuelve la poblacion de abejas en individuos
     * @return	cantidad de agua
     */
    public long getPoblacion()
    {
		...
    }

    /** Modifica la poblacion de abejas
     * @param poblacion	Nuevo numero d e abejas
     */
    public void setPoblacion(long poblacion)
    {
		...
    }

    @Override
    public void evoluciona(int dias)
    {
		double factorCrecimiento = 1.0;

		for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos())
		{
			...
		}
	}

    @Override
    public String toString(){
	return "Abejas: " + titulo + " - " + poblacion + " indivs. - Coord (" + posicion.x + "," + posicion.y + ") - Tamano (" + dimension.width + "," + dimension.height + ")";
    }

}
