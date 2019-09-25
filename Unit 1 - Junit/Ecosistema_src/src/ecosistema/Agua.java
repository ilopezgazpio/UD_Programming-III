package ecosistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** Clase para instanciar elementos de ecosistema de tipo agua
 * @author
 */
public class Agua extends ElementoEcosistema
{
    protected long cantidad;  // Cantidad de agua (en hectolitros)

    /** Constructor de agua. La inicializa con una cantidad = raiz cuadrada de anchura * altura
     * @param titulo	Titulo (nombre)
     * @param x	Coordenada x
     * @param y	Coordenada y
     * @param anch	Anchura (en pixels)
     * @param alt	Altura (en pixels)
     */
    public Agua(String titulo, int x, int y, int anch, int alt)
    {
        ...
    }


    /** Devuelve la cantidad de agua en hectolitros
     * @return	cantidad de agua
     */
    public long getCantidad()
    {
        ...
    }

    /** Modifica la cantidad de agua 
     * @param cantidad	hectolitros de agua
     */
    public void setCantidad(long cantidad)
    {
        ...
    }

    @Override
    public String toString()
    {
        return "Agua: " + titulo + " - " + cantidad + " metros cubicos - Coord (" + posicion.x + "," + posicion.y + ") - Tamano (" + dimension.width + "," + dimension.height + ")";
    }

}
