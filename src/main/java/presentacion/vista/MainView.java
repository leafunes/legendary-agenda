package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class MainView
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	//private DefaultTableModel modelPersonas;
	//private  String[] nombreColumnas = {"Nombre y apellido","Teléfono"};

	public MainView() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame("Legendary Agenda");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 798, 575);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(0, 0, 798, 524);
		panel.add(spPersonas);
		
		//modelPersonas = new DefaultTableModel(null,nombreColumnas);
		//tablaPersonas = new JTable(modelPersonas);
		tablaPersonas = new JTable();
		

		
		spPersonas.setViewportView(tablaPersonas);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(641, 538, 95, 25);
		panel.add(btnReporte);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(230, 538, 95, 25);
		panel.add(btnBorrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(448, 538, 95, 25);
		panel.add(btnEditar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(40, 538, 95, 25);
		panel.add(btnAgregar);
	}
	
	public void show()
	{
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
//	public DefaultTableModel getModelPersonas() 
//	{
//		return modelPersonas;
//	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

//	public String[] getNombreColumnas() 
//	{
//		return nombreColumnas;
//	}
}
