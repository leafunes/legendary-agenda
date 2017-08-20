package main;

import modelo.Agenda;
import presentacion.controlador.MainViewController;
import presentacion.vista.MainView;


public class Main 
{

	public static void main(String[] args) 
	{
		MainView vista = new MainView();
		Agenda modelo = new Agenda();
		MainViewController controlador = new MainViewController(vista, modelo);
		controlador.inicializar();
	}
}
