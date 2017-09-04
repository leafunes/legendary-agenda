package presentacion.vista;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListadoTipoContactoView extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JPanel panelButtons;
    private Component horizontalStrut;


    public ListadoTipoContactoView() {
        setTitle("Tipo de contacto");
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
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        btnAgregar = new JButton("Agregar");
        panelButtons.add(btnAgregar);
                
        horizontalStrut = Box.createHorizontalStrut(50);
        panelButtons.add(horizontalStrut);

        btnBorrar = new JButton("Borrar");
        panelButtons.add(btnBorrar);
        
        setLocationRelativeTo(null);
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
