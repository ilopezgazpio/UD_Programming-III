package examples;

import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.*;

public class Dialog
{

	private static JFrame miVentana;
	private static JLabel lMensaje = new JLabel( " " );
	private static boolean flag = false;
	
	public static void main(String[] args)
	{
		miVentana = new JFrame( "Ventana principal" );
		miVentana.setSize( 600, 400 );

		JPanel pBot = new JPanel();
		JButton bTest = new JButton( "Test Dialogo" );

		pBot.add( bTest );
		miVentana.add( pBot, BorderLayout.SOUTH );
		miVentana.add( lMensaje, BorderLayout.NORTH );
		miVentana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

		// Eventos de Dialogo
		bTest.addActionListener (
				(e) ->
				{
					flag = false;
					// Lanzamiento de un modal desde swing
					JDialog dialogo = new JDialog( miVentana, "Dialogo de la ventana principal" );
					dialogo.setModalityType( ModalityType.APPLICATION_MODAL );
					// MUY IMPORTANTE si se quiere el comportamiento modal
					dialogo.setSize( 300, 200 );
					JPanel pBot2 = new JPanel();
					JButton bTest2 = new JButton( "Cerrar" );
					pBot2.add( bTest2 );
					bTest2.addActionListener(
							(e2) -> { flag = true; dialogo.dispose(); }
					);

					dialogo.getContentPane().add( pBot2, BorderLayout.SOUTH );
					dialogo.setVisible( true );

					lMensaje.setText( "Se acaba el dialogo con el boton? " + flag );
		} );


		try
		{
			SwingUtilities.invokeAndWait(
					() -> { miVentana.setVisible( true ); }
			);
		}
		catch (Exception e1)
		{

		}

		JDialog dialogo = new JDialog( (JFrame)null, "Dialogo de la ventana principal" );

		dialogo.setModalityType( ModalityType.APPLICATION_MODAL );
		dialogo.setSize( 300, 200 );

		JPanel pBot3 = new JPanel();
		JButton bTest3 = new JButton( "Cerrar" );
		pBot3.add( bTest3 );
		bTest3.addActionListener( (e3) -> { dialogo.dispose(); } );
		dialogo.getContentPane().add( pBot3, BorderLayout.SOUTH );
		dialogo.setVisible( true );
	}
}
