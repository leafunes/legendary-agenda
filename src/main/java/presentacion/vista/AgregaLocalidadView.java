package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;

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
	    setSize(new Dimension(345, 185));
		setResizable(false);
	    
	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(new MigLayout("fill", "[][][][][][][]", "[][][pref!][][pref!]"));
	    
	    JLabel lblLocalidad = new JLabel("Localidad: ");
	    contentPane.add(lblLocalidad, "cell 1 2,alignx trailing");
	    
	    txtNombre = new JTextField();
	    txtNombre.setColumns(10);
	    contentPane.add(txtNombre, "cell 2 2 4 1,growx");
	    
	    btnAgregar = new JButton("Agregar");
	    contentPane.add(btnAgregar, "cell 5 4");
	    
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
