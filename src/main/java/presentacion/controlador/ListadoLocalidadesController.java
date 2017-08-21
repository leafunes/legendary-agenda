package presentacion.controlador;

import presentacion.vista.ListadoLocalidadesView;

public class ListadoLocalidadesController {
	
	private static ListadoLocalidadesController instancia;
	
	private ListadoLocalidadesView view;
	private AgregaLocalidadController agregaLocController;
	
	public static ListadoLocalidadesController getController(){
		if(instancia == null)
			instancia = new ListadoLocalidadesController();
		return instancia;
	}
	
	private ListadoLocalidadesController(){
		view = new ListadoLocalidadesView();
		agregaLocController = new AgregaLocalidadController();
		
		view.getBtnAgregar().addActionListener(e -> agregarContacto());
		
	}
	
	private void agregarContacto(){
		agregaLocController.showView();
	}
	
	public void showView(){
		view.setVisible(true);
	}
	
	public void closeView(){
		view.dispose();
	}

}
