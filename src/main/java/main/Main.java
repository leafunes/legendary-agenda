package main;

import modelo.PersonaService;
import presentacion.controlador.MainController;
import presentacion.vista.MainView;


public class Main 
{

	public static void main(String[] args) 
	{
		MainView vista = MainView.getView();
		PersonaService modelo = PersonaService.getService();//TODO: cambiar (casi) todo a singleton o con spring
		MainController controlador = new MainController(vista, modelo);
		controlador.showView();
	}
}
