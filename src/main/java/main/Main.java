package main;

import modelo.PersonaService;
import presentacion.controlador.MainViewController;
import presentacion.vista.MainView;


public class Main 
{

	public static void main(String[] args) 
	{
		MainView vista = new MainView();
		PersonaService modelo = PersonaService.getService();//TODO: cambiar (casi) todo a singleton o con spring
		MainViewController controlador = new MainViewController(vista, modelo);
		controlador.showView();
	}
}
