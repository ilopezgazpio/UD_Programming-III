package coche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

/** Clase principal de minijuego de coche para Practica 00 - Prog III
 * Ventana del minijuego.
 * @author Andoni Eguiluz
 * Facultad de Ingenieria - Universidad de Deusto (2014)
 */
public class VentanaJuego extends JFrame
{
	private static final long serialVersionUID = 1L;  // Para serializacion
	... pPrincipal;         // Panel del juego (layout nulo)
	... miCoche;        // Coche del juego
	... miHilo = null;  // Hilo del bucle principal de juego

	/** Constructor de la ventana de juego. Crea y devuelve la ventana inicializada
	 * sin coches dentro
	 */
	public VentanaJuego()
	{
	    // Liberacion de la ventana por defecto al cerrar
	    ...

	    // Creacion contenedores y componentes
	    pPrincipal = ...
	    JPanel pBotonera = ...
	    JButton bAcelerar = ...
	    JButton bFrenar = ...
	    JButton bGiraIzq = ...
	    JButton bGiraDer = ...
		
	    // Formato y layouts
	    pPrincipal.setLayout( null );
	    pPrincipal.setBackground( Color.white );

	    // Anadido de componentes a contenedores
	    add( ..., BorderLayout.CENTER );
	    pBotonera. ...
		...
		...
		...
	    add( ..., BorderLayout.SOUTH );

	    // Formato de ventana
	    setSize( 700, 500 );
	    
	    // Escuchadores de botones
	    bAcelerar.addActionListener( new ...()
		{
		    @Override
		    public void actionPerformed(... e)
		    {
			if (miCoche.getVelocidad()==0)
			    miCoche.acelera( +5 );
			else
			    miCoche.acelera( +5 );		
			System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
		    }
		});

	    bFrenar.addActionListener ...

	    bGiraIzq.addActionListener ...

	    bGiraDer.addActionListener ...

		// Anadido para que tambien se gestione por teclado con el KeyListener
		pPrincipal.addKeyListener( new ...()
		    {
			@Override
			public void keyPressed(... e)
			{
			    switch (e. ... ())
				{
				case KeyEvent.VK_UP:
				    {
					...
					break;
				    }
				case KeyEvent.VK_DOWN:
				    {
					...
					break;
				    }
				case KeyEvent.VK_LEFT:
				    {
					...
					break;
				    }
				case KeyEvent.VK_RIGHT:
				    {
					...
					break;
				    }
				}
			}
		    });

		pPrincipal.setFocusable(true);
		pPrincipal.requestFocus();
		pPrincipal.addFocusListener( new FocusAdapter()
		    {
			@Override
			public void focusLost(FocusEvent e)
			{
			    pPrincipal.requestFocus();
			}
		    });

		// Cierre del hilo al cierre de la ventana
		addWindowListener( new WindowAdapter()
		    {
			@Override
			public void windowClosing(WindowEvent e)
			{
			    if (miHilo!=null) ... ;
			}
		    });
	}

    /** Crea un coche nuevo y lo anade a la ventana
     * @param posX	Posicion X de pixel del nuevo coche
     * @param posY	Posicion Y de pixel del nuevo coche
     */
    public void creaCoche( int posX, int posY )
    {
	// Crear y anadir el coche a la ventana
	miCoche = ... 
	miCoche.set ...
	pPrincipal.add( ... );
    }

    /** Programa principal de la ventana de juego
     * @param args
     */
    public static void main(String[] args)
    {
	// Crea y visibiliza la ventana con el coche
	... miVentana = new ...
	miVentana. ...
	miVentana.set ...
	miVentana.miCoche.setPiloto( "Fernando Alonso" );
	
	// Crea el hilo de movimiento del coche y lo lanza
	miVentana.miHilo = miVentana.new MiRunnable();  // Sintaxis de new para clase interna
	
	... nuevoHilo = new ...( ... );
	nuevoHilo.start();
    }

	/** Clase interna para implementacion de bucle principal del juego como un hilo
	 * @author Andoni Eguiluz
	 * Facultad de Ingenieria - Universidad de Deusto (2014)
	 */
	class MiRunnable implements Runnable
	{
	    boolean sigo = true;
	    @Override
	    public void run()
	    {
		// Bucle principal forever hasta que se pare el juego...
		while (sigo)
		    {
			// Mover coche
			... ( 0.040 );
			// Chequear choques
			if ( ... < -JLabelCoche.TAMANYO_COCHE/2 || ... >pPrincipal.getWidth()-JLabelCoche.TAMANYO_COCHE/2 )
			    {
				// Espejo horizontal si choca en X
				System.out.println( "Choca X");
				double dir = ...
				dir = 180-dir;   // Rebote espejo sobre OY (complementario de 180)
				if (dir < 0) dir = 360+dir;  // Correccion para mantenerlo en [0,360)
				...
			    }
			// Se comprueba tanto X como Y porque podria a la vez chocar en las dos direcciones
			if (... < -JLabelCoche.TAMANYO_COCHE/2 || ... >pPrincipal.getHeight()-JLabelCoche.TAMANYO_COCHE/2 )
			    {
				// Espejo vertical si choca en Y
				System.out.println( "Choca Y");
				double dir = ...
				dir = 360 - dir;  // Rebote espejo sobre OX (complementario de 360)
				...
			    }
			// Dormir el hilo 40 milisegundos
			try {
			    Thread. ... ( 40 );
			} catch (Exception e) {
			}
		    }
	    }
	    
	    /** Ordena al hilo detenerse en cuanto sea posible
	     */
	    public void acaba()
	    {
		sigo = false;
	    }
	    
	}
}
