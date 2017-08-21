package presentacion.controlador;

import dto.PersonaDTO;
import modelo.PersonaService;
import presentacion.vista.AgregaPersonaView;

public class AgregaPersonaController {

	private AgregaPersonaView view;
	private PersonaService personaService = PersonaService.getService();
	
	public AgregaPersonaController() {
	
		view = new AgregaPersonaView();
		
		view.getBtnAgregarPersona().addActionListener(e -> crearContacto());
	
	}
	
	private void crearContacto(){
		this.personaService.agregar(getNewPersonaDTO());
		this.closeView();
	}
	
	
	public void showView(){
		view.setVisible(true);
	}
	
	public void closeView(){
		view.getTxtNombre().setText("");
		view.getTxtTelefono().setText("");
		view.dispose();
	}
	
	private PersonaDTO getNewPersonaDTO(){
		PersonaDTO nuevaPersona = new PersonaDTO(0,this.view.getTxtNombre().getText(), view.getTxtTelefono().getText());
		
		return nuevaPersona;
	}
	
}
