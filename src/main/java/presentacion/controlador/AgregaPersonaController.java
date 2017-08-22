package presentacion.controlador;

import dto.PersonaDTO;
import modelo.PersonaService;
import presentacion.vista.AgregaPersonaView;

public class AgregaPersonaController {

	private AgregaPersonaView view;
	private PersonaService personaService = PersonaService.getService();
	
	private PersonaDTO oldPersona;
	
	public AgregaPersonaController() {
	
		view = new AgregaPersonaView();
		
		view.getBtnAgregarPersona().addActionListener(e -> crearContacto());
		view.getBtnGuardar().addActionListener(e -> actualizeContacto());
		
	
	}
	
	private void crearContacto(){
		this.personaService.agregar(getNewPersonaDTO());
		this.closeView();
	}
	
	private void actualizeContacto(){
		//TODO
	}
	
	public void editaPersona(PersonaDTO p){
		view.setTitle("Editar Contacto");
		
		oldPersona = p;
		
		view.getTxtNombre().setText(p.getNombre());
		view.getTxtTelefono().setText(p.getTelefono());
		view.getBtnAgregarPersona().setVisible(false);
		view.getBtnGuardar().setVisible(true);
	}
	
	public void agregaPersona(){
		view.setTitle("Agregar Contacto");
		

		view.getTxtNombre().setText("");
		view.getTxtTelefono().setText("");
		view.getBtnAgregarPersona().setVisible(true);
		view.getBtnGuardar().setVisible(false);
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
