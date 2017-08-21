package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView
{
	private static MainView instance;
	
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JMenuBar menuBar;
	private JMenu mnEditar;
	private JMenuItem mntmLocalidades;
	private JMenuItem mntmTipoContacto;
	
	public static MainView getView(){
		if(instance == null)
			instance = new MainView();
		return instance;

	}

	private MainView() 
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
		spPersonas.setBounds(0, 0, 798, 504);
		panel.add(spPersonas);
		
		tablaPersonas = new JTable();
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(641, 516, 95, 25);
		panel.add(btnReporte);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(229, 516, 95, 25);
		panel.add(btnBorrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(448, 516, 95, 25);
		panel.add(btnEditar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(40, 516, 95, 25);
		panel.add(btnAgregar);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		mntmLocalidades = new JMenuItem("Localidades");
		mnEditar.add(mntmLocalidades);
		
		mntmTipoContacto = new JMenuItem("Tipos Contacto");
		mnEditar.add(mntmTipoContacto);
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
	
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}


	public JMenuItem getMntmLocalidades() {
		return mntmLocalidades;
	}

}
