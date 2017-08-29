package presentacion.vista;


import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

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
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

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
	private JPanel panelButtons;
	private Component glue;

	public AgregaPersonaView() 
	{
		super();
		setTitle("Agregar Contacto");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(650, 260));
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, 638, 185);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[pref!][185.00px][pref!][57.00px][60.00][60.00]", "[pref!][pref!][pref!][pref!][pref!]"));
		
		JLabel lblTipoContacto = new JLabel("Tipo Contacto:");
		panel.add(lblTipoContacto, "cell 0 0,grow");
		
		tipoCombo = new JComboBox<>();
		panel.add(tipoCombo, "cell 1 0,growx,aligny center");
		
				
				JLabel lblAltura = new JLabel("Altura:");
				panel.add(lblAltura, "cell 2 0,grow");
		
		txtAltura = new JTextField();
		panel.add(txtAltura, "cell 3 0 3 1,growx");
		txtAltura.setColumns(10);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		panel.add(lblNombreYApellido, "cell 0 1,grow");
		
		txtNombre = new JTextField();
		panel.add(txtNombre, "cell 1 1,grow");
		txtNombre.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		panel.add(lblPiso, "cell 2 1,grow");
		
		txtPiso = new JTextField();
		panel.add(txtPiso, "cell 3 1,grow");
		txtPiso.setColumns(10);
		
		JLabel lblDpto = new JLabel("Dpto.:");
		panel.add(lblDpto, "cell 4 1,grow");
		
		txtDpto = new JTextField();
		panel.add(txtDpto, "cell 5 1,grow");
		txtDpto.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		panel.add(lblTelfono, "cell 0 2,grow");
		
		txtTelefono = new JTextField();
		panel.add(txtTelefono, "cell 1 2,growx,aligny center");
		txtTelefono.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		panel.add(lblLocalidad, "cell 2 2,grow");
		
		localidadCombo = new JComboBox<>();
		panel.add(localidadCombo, "cell 3 2 3 1,grow");
		
		lblCumpleaos = new JLabel("Cumpleaños:");
		panel.add(lblCumpleaos, "cell 0 3,grow");
		
		calendar = new JDateChooser();
		panel.add(calendar, "cell 1 3,grow");
		
		lblEmail = new JLabel("Email:");
		panel.add(lblEmail, "cell 2 3,grow");
		
		txtEmail = new JTextField();
		panel.add(txtEmail, "cell 3 3 3 1,grow");
		txtEmail.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle:");
		panel.add(lblCalle, "cell 0 4,grow");
		
		txtCalle = new JTextField();
		panel.add(txtCalle, "cell 1 4,grow");
		txtCalle.setColumns(10);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tipoCombo, txtNombre, txtTelefono, calendar, txtCalle, txtAltura, txtPiso, txtDpto, localidadCombo, txtEmail, lblTipoContacto, lblNombreYApellido, lblTelfono, lblCumpleaos, lblCalle, lblAltura, lblPiso, lblLocalidad, lblEmail, calendar.getCalendarButton(), lblDpto}));
		
		panelButtons = new JPanel();
		panelButtons.setBounds(5, 185, 638, 44);
		contentPane.add(panelButtons);
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		
		glue = Box.createGlue();
		panelButtons.add(glue);
		
		btnGuardar = new JButton("Guardar");
		panelButtons.add(btnGuardar);
		
		btnAgregarPersona = new JButton("Agregar");
		panelButtons.add(btnAgregarPersona);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panelButtons.add(horizontalStrut);
		btnGuardar.setVisible(false);
		
		this.setLocationRelativeTo(null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tipoCombo, txtNombre, txtTelefono, calendar, calendar.getCalendarButton(), txtCalle, txtAltura, txtPiso, txtDpto, localidadCombo, txtEmail, btnGuardar, btnAgregarPersona, contentPane, panel, lblTipoContacto, lblAltura, lblNombreYApellido, lblPiso, lblDpto, lblTelfono, lblLocalidad, lblCumpleaos, lblEmail, lblCalle, panelButtons, glue, horizontalStrut}));
		
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

