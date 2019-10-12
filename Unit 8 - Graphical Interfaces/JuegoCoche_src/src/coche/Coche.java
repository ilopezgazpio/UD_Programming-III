package coche;

/** Clase para definir instancias logicas de coches con posicion, direccion y velocidad.
 * @author Andoni Eguiluz
 * Facultad de Ingenieria - Universidad de Deusto (2014)
 */
public class Coche
{
    protected double miVelocidad;  // Velocidad en pixels/segundo
    protected double miDireccionActual;  // Direccion en la que estoy mirando en grados (de 0 a 360)
    protected double posX;  // Posicion en X (horizontal)
    protected double posY;  // Posicion en Y (vertical)
    protected String piloto;  // Nombre de piloto

    // Constructores
    public Coche()
    {
        miVelocidad = ...
        miDireccionActual = ...
        posX = ...
        posY = ...
    }

    /** Devuelve la velocidad actual del coche en pixeles por segundo
     * @return	velocidad
     */
    public double getVelocidad()
    {
	...
    }

    /** Cambia la velocidad actual del coche
     * @param miVelocidad
     */
    public void setVelocidad( double miVelocidad )
    {
	...
    }

    public double getDireccionActual()
    {
	...
    }

    public void setDireccionActual( double dir )
    {
        if (dir < 0) ...
        if (dir > 360) ...
	    ...
    }

    public double getPosX()
    {
	...
    }

    public double getPosY()
    {
	...
    }

    public void setPosicion( double posX, double posY )
    {
        ...
    }

    public void setPosX( double posX )
    {
	...
    }

    public void setPosY( double posY )
    {
	...
    }

    public String getPiloto()
    {
	...
    }

    public void setPiloto(String piloto)
    {
	...
    }


    /** Cambia la velocidad actual del coche
     * @param aceleracion	Incremento/decremento de la velocidad en pixels/segundo
     */
    public void acelera( double aceleracion )
    {
	...
    }

    /** Cambia la direccion actual del coche
     * @param giro	Angulo de giro a sumar o restar de la direccion actual, en grados (-180 a +180)
     * 				Considerando positivo giro antihorario, negativo giro horario
     */
    public void gira( double giro )
    {
	setDireccionActual( ... );
    }

    /** Cambia la posicion del coche dependiendo de su velocidad y direccion
     * @param tiempoDeMovimiento	Tiempo transcurrido, en segundos
     */
    public void mueve( double tiempoDeMovimiento )
    {
        setPosX( ... + ... * Math.cos( ... /180.0*Math.PI) * ... );
        setPosY( ... + ... * -Math.sin( ... /180.0*Math.PI) * ... );
        // el negativo es porque en pantalla la Y crece hacia abajo y no hacia arriba
    }

    @Override
    public String toString()
    {
        ...
    }
}
