package presentacion.controlador;

import presentacion.vista.MainView;

public class MainViewMenuController {
	
	MainView view = MainView.getView();
	
	ListadoLocalidadesController localidadesController = ListadoLocalidadesController.getController();

	ListadoTipoContactoController tipoContactoController = ListadoTipoContactoController.getController();


	
	public MainViewMenuController() {
		
		
		
	}
	
	public void init(){

		view.getMntmLocalidades().addActionListener(e -> showLocalidadesView());

		view.getMntmTipoContacto().addActionListener(e -> showTipoContactoView());
	}
	
	private void showLocalidadesView(){
		localidadesController.showView();
	}

	private void showTipoContactoView(){
		tipoContactoController.showView();
	}

}
