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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;

public class ListadoLocalidadesView extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JPanel panelButtons;
	private Component glue;
	private Component glue_1;
	private Component glue_2;

	
	public ListadoLocalidadesView() {
		setTitle("Localidades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(450, 300));
		
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
		panelButtons.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		contentPane.add(panelButtons);
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		
		glue_1 = Box.createGlue();
		panelButtons.add(glue_1);
		
		btnAgregar = new JButton("Agregar");
		panelButtons.add(btnAgregar);
		
		glue_2 = Box.createGlue();
		panelButtons.add(glue_2);
		
		btnBorrar = new JButton("Borrar");
		panelButtons.add(btnBorrar);
		
		glue = Box.createGlue();
		panelButtons.add(glue);

		this.setLocationRelativeTo(null);
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
