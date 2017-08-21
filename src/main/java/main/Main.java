package main;

import modelo.PersonaService;
import presentacion.controlador.MainViewController;
import presentacion.vista.MainView;


public class Main 
{

	public static void main(String[] args) 
	{
		MainView vista = new MainView();
		PersonaService modelo = new PersonaService();
		MainViewController controlador = new MainViewController(vista, modelo);
		controlador.showView();
	}
}
