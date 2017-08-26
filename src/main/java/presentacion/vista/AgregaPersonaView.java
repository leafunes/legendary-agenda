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

import com.toedter.calendar.*;

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
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDpto;
	private JLabel lblEmail;
	private JLabel lblCumpleaos;
	
	private JDateChooser calendar;
	private JTextField txtEmail;
	private JComboBox<String> tipoCombo;

	public AgregaPersonaView() 
	{
		super();
		setTitle("Agregar Contacto");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(100, 100, 650, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 648, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		calendar = new JDateChooser();
		calendar.setDateFormatString("dd/MM/YYYY");
		calendar.setBounds(167, 100, 164, 20);
		panel.add(calendar);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		lblNombreYApellido.setBounds(12, 44, 137, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(12, 70, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(167, 42, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(167, 68, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(268, 172, 95, 23);
		panel.add(btnAgregarPersona);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(268, 172, 95, 23);
		btnGuardar.setVisible(false);
		panel.add(btnGuardar);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(367, 70, 95, 15);
		panel.add(lblLocalidad);
		
		localidadCombo = new JComboBox<>();
		localidadCombo.setBounds(453, 65, 164, 24);
		panel.add(localidadCombo);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(12, 125, 70, 15);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(367, 14, 70, 15);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(367, 44, 70, 15);
		panel.add(lblPiso);
		
		JLabel lblDpto = new JLabel("Dpto.:");
		lblDpto.setBounds(516, 44, 70, 15);
		panel.add(lblDpto);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(167, 123, 164, 19);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(453, 12, 164, 19);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(453, 42, 55, 19);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtDpto = new JTextField();
		txtDpto.setBounds(562, 42, 55, 19);
		panel.add(txtDpto);
		txtDpto.setColumns(10);
		
		JLabel lblTipoContacto = new JLabel("Tipo Contacto:");
		lblTipoContacto.setBounds(12, 13, 118, 15);
		panel.add(lblTipoContacto);
		
		tipoCombo = new JComboBox<>();
		tipoCombo.setBounds(167, 6, 164, 24);
		panel.add(tipoCombo);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(367, 97, 70, 15);
		panel.add(lblEmail);
		
		lblCumpleaos = new JLabel("Cumpleaños:");
		lblCumpleaos.setBounds(12, 96, 100, 15);
		panel.add(lblCumpleaos);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(453, 100, 164, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
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

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public JTextField getTxtDpto() {
		return txtDpto;
	}

	public JDateChooser getCalendar() {
		return calendar;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JComboBox<String> getTipoCombo() {
		return tipoCombo;
	}
}

