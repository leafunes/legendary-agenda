package presentacion.controlador;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import modelo.LocalidadService;
import modelo.PersonaService;
import presentacion.vista.AgregaLocalidadView;
import presentacion.vista.AgregaPersonaView;

public class AgregaLocalidadController {

	private AgregaLocalidadView view;
	private LocalidadService localidadService = LocalidadService.getService();
	
	public AgregaLocalidadController() {
	
		view = new AgregaLocalidadView();
		
		view.getBtnAgregar().addActionListener(e -> crearLocalidad());
	
	}
	
	private void crearLocalidad(){
		this.localidadService.agregar(getNewLocalidadDTO());
		this.closeView();
	}
	
	
	public void showView(){
		view.setVisible(true);
	}
	
	public void closeView(){
		view.getTxtNombre().setText("");
		view.dispose();
	}
	
	private LocalidadDTO getNewLocalidadDTO(){
		LocalidadDTO nuevaLocalidad = new LocalidadDTO(0,this.view.getTxtNombre().getText());
		
		return nuevaLocalidad;
	}
}
