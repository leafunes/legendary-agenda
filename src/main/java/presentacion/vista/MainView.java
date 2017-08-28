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
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;

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
	private JButton btnEditar;
	private JPanel panelButtons;
	private Component glue;
	private Component glue_1;
	private Component glue_2;
	private Component glue_3;
	private Component glue_4;
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setMinimumSize(new Dimension(800, 600));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JScrollPane spPersonas = new JScrollPane();
		panel.add(spPersonas);
		
		tablaPersonas = new JTable();
		
		spPersonas.setViewportView(tablaPersonas);
		
		panelButtons = new JPanel();
		panelButtons.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		panel.add(panelButtons);
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		
		glue = Box.createGlue();
		panelButtons.add(glue);
		
		btnReporte = new JButton("Reporte");
		panelButtons.add(btnReporte);
		
		glue_1 = Box.createGlue();
		panelButtons.add(glue_1);
		
		btnBorrar = new JButton("Borrar");
		panelButtons.add(btnBorrar);
		
		glue_2 = Box.createGlue();
		panelButtons.add(glue_2);
		
		btnEditar = new JButton("Editar");
		panelButtons.add(btnEditar);
		
		glue_3 = Box.createGlue();
		panelButtons.add(glue_3);
		
		btnAgregar = new JButton("Agregar");
		panelButtons.add(btnAgregar);
		
		glue_4 = Box.createGlue();
		panelButtons.add(glue_4);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		mntmLocalidades = new JMenuItem("Localidades");
		mnEditar.add(mntmLocalidades);
		
		mntmTipoContacto = new JMenuItem("Tipos Contacto");
		mnEditar.add(mntmTipoContacto);

		frame.setLocationRelativeTo(null);
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

	public JMenuItem getMntmTipoContacto() {
		return mntmTipoContacto;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

}
