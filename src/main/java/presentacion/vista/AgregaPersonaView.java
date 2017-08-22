package presentacion.vista;


import java.awt.Dialog.ModalExclusionType;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.MainController;
import javax.swing.JComboBox;

public class AgregaPersonaView extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private JButton btnGuardar;
	private JComboBox<String> localidadCombo;

	public AgregaPersonaView() 
	{
		super();
		setTitle("Agregar Contacto");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(100, 100, 343, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 341, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		lblNombreYApellido.setBounds(10, 11, 137, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(165, 9, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(165, 50, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(234, 123, 95, 23);
		panel.add(btnAgregarPersona);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(234, 123, 95, 23);
		btnGuardar.setVisible(false);
		panel.add(btnGuardar);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(10, 93, 137, 15);
		panel.add(lblLocalidad);
		
		localidadCombo = new JComboBox<>();
		localidadCombo.setBounds(165, 88, 164, 24);
		panel.add(localidadCombo);
		
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JComboBox<String> getLocalidadCombo() {
		return localidadCombo;
	}
}

