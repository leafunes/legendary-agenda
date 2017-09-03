package presentacion.vista;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CambiaConfigDBView extends JDialog{
	private JTextField ipTxt;
	private JTextField puertoTxt;
	private JTextField usuarioTxt;
	private JPasswordField contraTxt;
	private JButton okBtt;
	public CambiaConfigDBView() {
		
		getContentPane().setLayout(null);
		setSize(new Dimension(400, 400));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblIp = new JLabel("Ip:");
		lblIp.setBounds(23, 31, 70, 15);
		getContentPane().add(lblIp);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(23, 58, 70, 15);
		getContentPane().add(lblPuerto);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(23, 85, 70, 15);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(23, 112, 101, 15);
		getContentPane().add(lblContrasea);
		
		okBtt = new JButton("Ok");
		okBtt.setBounds(232, 238, 117, 25);
		getContentPane().add(okBtt);
		
		ipTxt = new JTextField();
		ipTxt.setBounds(75, 29, 114, 19);
		getContentPane().add(ipTxt);
		ipTxt.setColumns(10);
		
		puertoTxt = new JTextField();
		puertoTxt.setBounds(85, 58, 114, 19);
		getContentPane().add(puertoTxt);
		puertoTxt.setColumns(10);
		
		usuarioTxt = new JTextField();
		usuarioTxt.setBounds(95, 83, 114, 19);
		getContentPane().add(usuarioTxt);
		usuarioTxt.setColumns(10);
		
		contraTxt = new JPasswordField();
		contraTxt.setBounds(124, 110, 85, 19);
		getContentPane().add(contraTxt);
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
