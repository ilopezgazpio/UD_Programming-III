package examples;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class SimpleTableModel implements TableModel
{
	Object datosEjemplo[][] = 
		{
				{ "Andoni", "Garcia", 14, "diciembre", 1968 },
				{ "Jennifer", "Lawrence",  15, "agosto", 1990 },
				{ "Leonardo", "di Caprio", 11, "noviembre", 1974 }
		};

	String columnas[] = { "Nombre", "Apellido", "dia", "mes", "anyo" };
	
	private static JTable tPrueba;
	private static SimpleTableModel modelo;
	
	public static void main(String[] args)
	{
		JFrame v = new JFrame();
		v.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

		tPrueba = new JTable( 5, 2 );
		modelo = new SimpleTableModel();
		tPrueba.setModel( modelo );

		JButton b = new JButton( "Test" );
		b.addActionListener(
				(e) -> {
					modelo.datosEjemplo[0][1] = "Eguiluz";
					// El cambio programatico no se detecta solo (hay independencia de la vista y el modelo)
					// tPrueba.tableChanged( new TableModelEvent( modelo, 0, 0, 1, 1));
				}
		);

		v.getContentPane().add( new JScrollPane( tPrueba ), BorderLayout.CENTER );
		v.getContentPane().add( b, BorderLayout.SOUTH );
		v.setSize( 600, 250 );
		v.setVisible( true );
	}
	
	@Override
	public int getRowCount()
	{
		return datosEjemplo.length;
	}

	@Override
	public int getColumnCount()
	{
		return datosEjemplo[0].length;
	}

	@Override
	public String getColumnName(int columnIndex)
	{
		return columnas[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		return datosEjemplo[0][columnIndex].getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		if (columnIndex==0) return false;
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		System.out.println( "Me piden (" + rowIndex + "," + columnIndex + ")" );
		return datosEjemplo[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		System.out.println( "Me cambian (" + rowIndex + "," + columnIndex + ") a " + aValue + " (" + aValue.getClass().getName() + ")" );
		datosEjemplo[rowIndex][columnIndex] = aValue;
	}

	private ArrayList<TableModelListener> myListeners = new ArrayList<>();

	@Override
	public void addTableModelListener(TableModelListener l) {
		myListeners.add( l );
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		myListeners.remove( l );
	}

}
