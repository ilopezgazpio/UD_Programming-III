package ecosistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** Clase para instanciar elementos de ecosistema de tipo flores
 * @author
 * Facultad de Ingenieria - Universidad de Deusto
 */
public class PlantacionFlores extends ElementoEcosistema implements Evolucionable
{
    protected long cantidad;  // Cantidad de flores (en unidades)

    /** Constructor de plantacion de flores. La inicializa con una cantidad = raiz cuadrada de anchura * altura
     * @param titulo	Titulo (nombre)
     * @param x	Coordenada x
     * @param y	Coordenada y
     * @param anch	Anchura (en pixels)
     * @param alt	Altura (en pixels)
     */
    public PlantacionFlores( String titulo, int x, int y, int anch, int alt )
    {
		...
    }

    /** Devuelve la cantidad de flores existentes
     * @return	cantidad de agua
     */
    public long getCantidad()
    {
		...
    }

    /** Modifica la cantidad de flores
     * @param cantidad	Nuevo numero de flores
     */
    public void setCantidad(long cantidad)
    {
		...
    }

    @Override
	public void evoluciona(int dias)
	{
		double factorCrecimiento = 0.75;
		for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos())
		{
			...
		}
	}

    @Override
    public String toString()
    {
	return "Flores: " + titulo + " - " + cantidad + " uds. - Coord (" + posicion.x + "," + posicion.y + ") - Tamano (" + dimension.width + "," + dimension.height + ")";
    }

}
