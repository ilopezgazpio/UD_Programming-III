package coche;

/** Clase para definir instancias de coches con sus datos logicos y una representacion
 * visual asociada lista para incluir en un panel de Swing.
 * Segun se mueva el coche, su representacion (JLabel) se movera en consonancia.
 * @author Andoni Eguiluz
 * Facultad de Ingenieria - Universidad de Deusto (2014)
 */
public class CocheJuego extends ...
{
    private ... miGrafico;  // Etiqueta grafica del coche

    /**  Crea un nuevo coche de juego
     */
    public CocheJuego()
    {
	miGrafico = ...
    }

    /** Devuelve el JLabel grafico asociado al coche de juego
     * @return	Etiqueta grafica del coche
     */
    public ... getGrafico()
    {
	...
    }

    @Override
    public void setPosX(double posX)
    {
        ...
        miGrafico.setLocation( ... );
    }

    @Override
    public void setPosY(double posY)
    {
	...
        miGrafico.setLocation( ... );
    }

    @Override
    public void setDireccionActual( double dir )
    {
	...
        miGrafico.setGiro( ... );
        miGrafico.repaint();  // Necesario porque Swing no redibuja al cambiar el giro (no pasa nada en el JLabel)
    }
}
