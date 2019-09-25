package ecosistema;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

/** Clase abstracta que modela todo elemento del ecosistema. Tiene titulo, posicion y tamano
 * @author
 */
public abstract class ElementoEcosistema
{
    protected String titulo;
    protected Point posicion;
    protected Dimension dimension;

    /** Devuelve el titulo del elemento de ecosistema
     * @return	Titulo (nombre)
     */
    public String getTitulo()
    {
        ...
    }

    /** Modifica el titulo (nombre) del elemento
     * @param titulo nuevo titulo
     */
    public void setTitulo(String titulo)
    {
        ...
    }

    /** Devuelve la posicion del elemento de ecosistema
     * @return	Posicion de la esquina superior izquierda
     */
    public Point getPosicion()
    {
        ...
    }

    /** Modifica la posicion del elemento
     * @param posicion nueva posicion
     */
    public void setPosicion(Point posicion)
    {
        ...
    }

    /** Devuelve el tamano del elemento de ecosistema
     * @return	Dimension con ancho y alto del elemento
     */
    public Dimension getDimension()
    {
        ...
    }

    /** Modifica la dimension del elemento
     * @param dimension nuevo tamano
     */
    public void setDimension(Dimension dimension)
    {
        ...
    }

}
