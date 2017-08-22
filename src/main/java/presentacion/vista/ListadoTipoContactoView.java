package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ListadoTipoContactoView extends JDialog {

    private JPanel contentPane;
    private JTable table;
    private JButton btnAgregar;
    private JButton btnBorrar;


    public ListadoTipoContactoView() {
        setTitle("Tipo de contacto");
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
