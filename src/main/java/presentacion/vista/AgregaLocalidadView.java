package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AgregaLocalidadView extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnAgregar;

	public AgregaLocalidadView() 
	{
		super();
		setTitle("Agregar Localidad");
		
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
		
		JLabel lblNombreYApellido = new JLabel("Localidad:");
		lblNombreYApellido.setBounds(12, 63, 137, 14);
		panel.add(lblNombreYApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(165, 57, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(234, 123, 95, 23);
		panel.add(btnAgregar);
		
		
		this.setLocationRelativeTo(null);
		
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

}
