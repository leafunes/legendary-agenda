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

public class ListadoLocalidadesView extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnBorrar;

	
	public ListadoLocalidadesView() {
		setTitle("Localidades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setModal(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(60, 238, 117, 25);
		contentPane.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(257, 238, 117, 25);
		contentPane.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 448, 226);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
