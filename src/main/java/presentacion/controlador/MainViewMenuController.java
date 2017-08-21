package presentacion.controlador;

import presentacion.vista.MainView;

public class MainViewMenuController {
	
	MainView view = MainView.getView();
	
	ListadoLocalidadesController localidadesController = ListadoLocalidadesController.getController();
	
	public MainViewMenuController() {
		
		
		
	}
	
	public void init(){

		view.getMntmLocalidades().addActionListener(e -> showLocalidadesView());
	}
	
	private void showLocalidadesView(){
		System.out.println("asd");
		localidadesController.showView();
	}

}
