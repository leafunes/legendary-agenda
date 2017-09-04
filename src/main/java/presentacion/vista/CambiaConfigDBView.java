package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class CambiaConfigDBView extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField ipTxt;
	private JTextField puertoTxt;
	private JTextField usuarioTxt;
	private JPasswordField contraTxt;
	private JButton okBtt;
	
	public CambiaConfigDBView() {
		setSize(new Dimension(300, 200));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new MigLayout("", "[][101px][128.00px][]", "[19px][19px][19px][19px][25px][]"));
		
		JLabel lblIp = new JLabel("Ip:");
		getContentPane().add(lblIp, "cell 1 0,growx,aligny center");
		
		JLabel lblPuerto = new JLabel("Puerto:");
		getContentPane().add(lblPuerto, "cell 1 1,alignx left,aligny center");
		
		JLabel lblUsuario = new JLabel("Usuario:");
		getContentPane().add(lblUsuario, "cell 1 2,alignx left,aligny center");
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		getContentPane().add(lblContrasea, "cell 1 3,growx,aligny center");
		
		okBtt = new JButton("Ok");
		getContentPane().add(okBtt, "cell 2 4,alignx center,aligny top");
		
		ipTxt = new JTextField();
		getContentPane().add(ipTxt, "cell 2 0,growx,aligny top");
		ipTxt.setColumns(10);
		
		puertoTxt = new JTextField();
		getContentPane().add(puertoTxt, "cell 2 1,growx,aligny top");
		puertoTxt.setColumns(10);
		
		usuarioTxt = new JTextField();
		getContentPane().add(usuarioTxt, "cell 2 2,growx,aligny top");
		usuarioTxt.setColumns(10);
		
		contraTxt = new JPasswordField();
		getContentPane().add(contraTxt, "cell 2 3,growx,aligny top");
		
		
	}
	public JTextField getIpTxt() {
		return ipTxt;
	}
	public JTextField getPuertoTxt() {
		return puertoTxt;
	}
	public JTextField getUsuarioTxt() {
		return usuarioTxt;
	}
	public JPasswordField getContraTxt() {
		return contraTxt;
	}
	public JButton getOkBtt() {
		return okBtt;
	}
	
	public void showView() {
		this.setVisible(true);
	}

}
