package operacionesConHerencia;

/** Clase principal del problema de los cuatro cuatros.
 * @author andoni
 *
 */
public class CuatroCuatros
{
	/** Variable final que permite activar la depuracion en consola de las llamadas recursivas
     * Si se pone a false, no se visualizan las llamadas.
     */
	private static final boolean VERLLAMADASRECURSIVAS = true;

	/** Forma el grupo de todas las operaciones posibles para el numero indicado de cuatros
	 * @param numCuatros Numero de cuatros que tendran todas las operaciones (de 1 a 4)
	 * @return Grupo resultado
	 */
	private static GrupoOperaciones formaOperaciones(int numCuatros )
    {
		// CODIGO DE DEPURACION PARA LA TRAZA DE LA RECURSIVIDAD (no afecta a la logica del algoritmo)
		if (VERLLAMADASRECURSIVAS)
		{
			for ( int k=0; k<(4-numCuatros); k++ ) System.out.print( "   " );
			System.out.println( "-> formaOperaciones( " + numCuatros + " )" );
		}
		// fin codigo depuracion

		// Grupo a devolver, inicialmente vacio
		... grupo = ...
		if (numCuatros == 1)
		{
			// Caso base: si solo hay un cuatro se crea un grupo con un elemento: 4

		}
		else
		{
			// Caso recursivo: se combinan todos los grupos posibles...
			// Dividiendo entre operando 1 y 2 los tamanos. Por ejemplo para numCuatros = 4:
			// i = 1 --> operando1 = 1, operando2 = 3
			// i = 2 --> operando1 = 2, operando2 = 2
			// i = 3 --> operando1 = 3, operando2 = 1
			// En general, se divide el numero de cuatros en todos los dos bloques posibles, cada uno de al menos un cuatro

			for (int i=1; i < numCuatros; i++)
			{

				// CODIGO DE DEPURACION PARA LA TRAZA DE LA RECURSIVIDAD (no afecta a la logica del algoritmo)
				if (VERLLAMADASRECURSIVAS)
				{
					for ( int k=0; k<(4-numCuatros); k++ ) System.out.print( "   " );
					System.out.println( "Calculando grupos de " + i + " y " + (numCuatros-i) + " cuatros" );
				}
				// fin codigo depuracion

				... grupo1 = formaOperaciones( ... ); // Grupo de operando 1
				... grupo2 = formaOperaciones( ... ); // Grupo de operando 2

				Operacion op1 = null;
				Operacion op2 = null;

				for (int indOp1 = 0; indOp1 < ...; indOp1++)
				{
					op1 = grupo1 ...( ... );

					for (int indOp2 = 0; indOp2 < ...; indOp2++)
					{
						op2 = grupo2 ... ( ... );
						// Todas las combinaciones posibles de op1 y op2, con las 4 operaciones:
						assert (op1 instanceof OperacionCuatros);
						assert (op2 instanceof OperacionCuatros);

						OperacionCuatros o41 = ( ... ) op1;  // Casting para poder operar con operacion de 4s
						OperacionCuatros o42 = ( ... ) op2;  // idem

						grupo ... ( new ...( ..., '+', ... ) );
						grupo ... ( new ...( ..., '-', ... ) );
						grupo ... ( new ...( ..., '*', ... ) );

						if (op2.getValor() != 0)  // Excepto aquellas operaciones que producen division por cero
							grupo ... ( new  ... ( ... , '/', ... ) );
					}
				}


				/* Solucion con Vector y bucles sin indice:
		       for (operacionesConHerencia.Operacion op1 : grupo1.getVector()) {
		       for (operacionesConHerencia.Operacion op2 : grupo2.getVector()) {
		       // Todas las combinaciones posibles de op1 y op2, con las 4 operaciones:
		       operacionesConHerencia.OperacionCuatros o41 = (operacionesConHerencia.OperacionCuatros) op1;
		       operacionesConHerencia.OperacionCuatros o42 = (operacionesConHerencia.OperacionCuatros) op2;
		       grupo.anyadirOperacion( new operacionesConHerencia.OperacionCuatros( o41, '+', o42 ) );
		       grupo.anyadirOperacion( new operacionesConHerencia.OperacionCuatros( o41, '-', o42 ) );
		       grupo.anyadirOperacion( new operacionesConHerencia.OperacionCuatros( o41, '*', o42 ) );
		       if (op2.getValor() != 0)  // Excepto aquellas operaciones que producen division por cero
		       grupo.anyadirOperacion( new operacionesConHerencia.OperacionCuatros( o41, '/', o42 ) );
		       // O mejor todavia aprovechando el array constante definido de operadores:
		       // for (char op : operacionesConHerencia.OperacionCuatros.OPERADORES_BINARIOS) {
		       //		if (op != '/')
		       // 			grupo.anyadirOperacion( new operacionesConHerencia.OperacionCuatros( op1, op, op1 ) );
		       // }
		       // if (op2.getValor() != 0)
		       // 		grupo.anyadirOperacion( new operacionesConHerencia.OperacionCuatros( op1, op, op1 ) );
		       }
		       }
		    */
			}
		}

		// CODIGO DE DEPURACION PARA LA TRAZA DE LA RECURSIVIDAD (no afecta a la logica del algoritmo)
		if (VERLLAMADASRECURSIVAS)
		{
			for ( int i=0; i<(4-numCuatros); i++ ) System.out.print( "   " );
			System.out.println( "<- formaOperaciones( " + numCuatros + " ): " + grupo );
		}

		return grupo;
		// fin codigo depuracion
	}

	/** Calcula todas las operaciones de cuatro cuatros y devuelve el grupo con esas operaciones
	 */
	private static GrupoOperaciones calcularOps()
	{
		...
	}

	/** Metodo principal de la aplicacion. Calcula todas las operaciones posibles y visualiza una para cada numero entero positivo
	 * @param s  Strings recibidos como parametros (no se procesa)
	 */
	public static void main (String[] s)
	{
		long tiempoInicial = System.currentTimeMillis();
		GrupoOperaciones g = calcularOps();

		// g.visualizar();
		int mayorValor = 0;
		for (Operacion o : g.getVector())
		{
			if (mayorValor < o.getValor()) mayorValor = Math.round(o.getValor());
		}


		int posicionValor[] = new int[mayorValor+1];
		int j = 0;

		for (Operacion o : g.getVector())
		{
			j++;
			int valorInt = Math.round( o.getValor() );
			if (o.getValor() == valorInt && valorInt >= 0 && posicionValor[valorInt] == 0) {
				posicionValor[valorInt] = j;
			}
		}

		for (int k = 0; k <= mayorValor; k++ )
		{
			if (posicionValor[k] > 0)
				System.out.println( g.cogerOperacion( posicionValor[k]-1 ) );
		}

		System.out.println( "Valores conseguidos con cuatro cuatros: ");
		for (int k = 0; k <= mayorValor; k++ )
		{
			if (posicionValor[k] > 0)
				System.out.print( Math.round((g.cogerOperacion( posicionValor[k]-1 )).getValor()) + ", " );
	    }

		System.out.println( "" );
		System.out.println( "Tiempo transcurrido: " + (System.currentTimeMillis() - tiempoInicial) + " milisegundos" );
	}
}
