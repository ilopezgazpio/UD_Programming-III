package ecosistema;

/** Clase de prueba del ecosistema en consola con algunos datos de ecosistema arbitrarios.
 * Se ejecuta indefinidamente, debe pararse la tarea externamente para detener el programa.
 * @author
 */
public class PruebaEcosistema
{
    /** Metodo principal.
     * @param args	No utilizado
     */
	public static void main(String[] args)
	{
		Agua agua = new Agua( ... );
		ColoniaAbejas abejas = new ColoniaAbejas( ... );
		PlantacionFlores flores = new PlantacionFlores( ... );

		Ecosistema ... .add( ... );
		...

		int dia=0;

		while (true)
		{
			System.out.println( "Dia " + dia );

			for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos())
			{
				System.out.println( "  " + ee );
			}

			for (ElementoEcosistema ee : Ecosistema.getMundo().getElementos())
			{
				... evoluciona ...
			}

			dia++;
			try { Thread.sleep( 1000 ); } catch (Exception e) {}
		}
	}

}
