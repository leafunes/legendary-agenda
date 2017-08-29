package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

public class ListadoLocalidadesView extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JPanel panelButtons;
	private Component horizontalStrut;

	
	public ListadoLocalidadesView() {
		setTitle("Localidades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450, 300);
		setResizable(false);
		
		setModal(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panelButtons = new JPanel();
		contentPane.add(panelButtons);
		
		btnAgregar = new JButton("Agregar");
		panelButtons.add(btnAgregar);
		
		horizontalStrut = Box.createHorizontalStrut(50);
		panelButtons.add(horizontalStrut);
		
		btnBorrar = new JButton("Borrar");
		panelButtons.add(btnBorrar);
	}


	public JTable getTable() {
		return table;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public JButton getBtnBorrar() {
		return btnBorrar;
	}
}
