package coche;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** Clase para visualizar un coche en Swing como un JLabel,
 *  con un grafico especifico de coche
 * @author Andoni Eguiluz
 */
public class JLabelCoche extends ...
{
    private static final long serialVersionUID = 1L;  // Para serializacion
    public static final int TAMANYO_COCHE = 100;  // pixels (igual ancho que algo)

    /** Construye y devuelve el JLabel del coche con su grafico y tamano
     */
    public JLabelCoche()
    {
        // Esto se haria para acceder por sistema de ficheros
        // super( new ImageIcon( "bin/ud/prog3/pr00/coche.png" ) );
        // Esto se hace para acceder tanto por recurso (jar) como por fichero
        try
        {
            setIcon( new ImageIcon( JLabelCoche.class.getResource("coche.png").toURI().toURL() ) );
        }
        catch (Exception e)
        {
            System.err.println( "Error en carga de recurso: coche.png no encontrado" );
            e.printStackTrace();
        }
        setBounds( 0, 0, ..., ... );
        // Esto seria util cuando hay algun problema con el grafico: borde de color del JLabel
        // setBorder( BorderFactory.createLineBorder( Color.yellow, 4 ));
    }

    // giro
    private double miGiro = Math.PI/2;

    /** Cambia el giro del JLabel
     * @param gradosGiro	Grados a los que tiene que "apuntar" el coche,
     * 	considerados con el 0 en el eje OX positivo,
     * 	positivo en sentido antihorario, negativo horario.
     */
    public void setGiro( double gradosGiro )
    {
        // De grados a radianes...
        miGiro = ...
        // El giro en la pantalla es en sentido horario (inverso):
        miGiro = -miGiro;  // Cambio el sentido del giro
        // Y el grafico del coche apunta hacia arriba (en lugar de derecha OX)
        miGiro = miGiro + Math.PI/2; // Sumo 90 para que corresponda al origen OX
    }

    // Redefinicion del paintComponent para que se escale y se rote el grafico
    @Override
    protected void paintComponent(Graphics g)
    {
        // super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
        Image img = ((ImageIcon)getIcon()).getImage();
        Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
        // Escalado mas fino con estos 3 parametros:
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        // Prepara rotacion (siguientes operaciones se rotaran)
        g2.rotate( miGiro, 50, 50 ); // getIcon().getIconWidth()/2, getIcon().getIconHeight()/2 );
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, TAMANYO_COCHE, TAMANYO_COCHE, null );
    }
}
