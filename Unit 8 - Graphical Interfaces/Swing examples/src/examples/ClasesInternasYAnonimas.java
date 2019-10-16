package examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.Random;


//Opcion  1: clase externa
class EscuchadorBotonVentanaHilos1 implements ActionListener
{
	JTextArea ta;

	public EscuchadorBotonVentanaHilos1(JTextArea ta)
	{
		this.ta = ta;
	}

	public void actionPerformed(ActionEvent e)
	{
		ta.append( "Soy Swing y detecto [ESCUCHADOR EXTERNO] Boton Pulsado: " + new Date() + "\n" );
	}
}


public class ClasesInternasYAnonimas extends JFrame
{
	
	// Opcionn 2: clase interna
	private class EscuchadorBotonVentanaHilos2 implements ActionListener
	{
		// Con clase interna, hay acceso directo a los atributos de la clase que la engloba
        // JTextArea ta;

		// public EscuchadorBotonVentanaHilos2(JTextArea ta)
		// {
		// this.ta = ta;
	    // }

		public void actionPerformed(ActionEvent e) {
			area.append( "Soy Swing y detecto [ESCUCHADOR INTERNO] Boton Pulsado: " + new Date() + "\n" );
		}
	}

	JPanel panelBoton;
	JTextArea area;
	JButton boton;

	public ClasesInternasYAnonimas()
	{
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  // Cerramos el programa para acabar tambi�n el hilo de main (con DISPOSE_ON_CLOSE este seguir�a)
		area = new JTextArea( 20, 50 );
		panelBoton = new JPanel();
		boton = new JButton("Pulsa Aqui");

		panelBoton.add(boton);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add( new JScrollPane(area), "Center" );
		this.getContentPane().add(panelBoton,"South");

		// Con las opciones 1 o 2, se añade un objeto escuchador
		
		// Con la 1 (externa) se crea pasando info de la textarea
		EscuchadorBotonVentanaHilos1 escuchador1 = new EscuchadorBotonVentanaHilos1( area );
		boton.addActionListener( escuchador1 );

		// Con la 2 (interna) no hace falta esa informacion
		EscuchadorBotonVentanaHilos2 escuchador2 = new EscuchadorBotonVentanaHilos2( );
		boton.addActionListener( escuchador2 );
		
		// Opcion 3: Clase interna anonima
        //
        //	ActionListener escuchador3 = new ActionListener()
		// {
        //	public void actionPerformed(ActionEvent e)
		//	{
        //	  area.append( "Soy Swing y detecto [CLASE ANONIMA] Boton Pulsado: " + new Date() + "\n" );
		//  }
        // }

        // boton.addActionListener( escuchador3 );


		// Otra alternativa de clase anonima
		boton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					area.append( "Soy Swing y detecto [CLASE ANONIMA AL VUELO] Boton Pulsado: " + new Date() + "\n" );
				}
			}
		);


		// Otra alternativa de clase anonima con expresiones lambda
		boton.addActionListener(
				e -> area.append( "Soy Swing y detecto [CLASE ANONIMA LAMBDA] Boton Pulsado: " + new Date() + "\n" )
		);

		this.setSize(600,400);
		this.setTitle("Ejemplo Sencillo para entender hilos");
	}
	

	public static void main(String[] args)
	{
		ClasesInternasYAnonimas v = new ClasesInternasYAnonimas();
		v.setVisible(true);
	}
}
