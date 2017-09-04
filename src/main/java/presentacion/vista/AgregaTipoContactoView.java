package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AgregaTipoContactoView extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombre;
    private JButton btnAgregar;

    public AgregaTipoContactoView(){

	    super();
	    setTitle("Agregar tipo de contacto");
	
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setModal(true);
	    setSize(new Dimension(345, 185));
		setResizable(false);
	
	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(new MigLayout("fill", "[][][][][][][]", "[][][][][pref!]"));
	    
	    JLabel lblTipoDeContacto = new JLabel("Tipo de contacto: ");
	    contentPane.add(lblTipoDeContacto, "cell 1 2,alignx trailing");
	    
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
