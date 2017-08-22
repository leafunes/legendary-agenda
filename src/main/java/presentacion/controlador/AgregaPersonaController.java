package presentacion.controlador;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import modelo.LocalidadService;
import modelo.PersonaService;
import presentacion.combo.LocalidadComboModel;
import presentacion.vista.AgregaPersonaView;

public class AgregaPersonaController {

	private AgregaPersonaView view;
	private PersonaService personaService = PersonaService.getService();
	private LocalidadService localidadService = LocalidadService.getService();
	
	private LocalidadComboModel comboModel;
	
	private PersonaDTO oldPersona;
	
	public AgregaPersonaController() {
	
		view = new AgregaPersonaView();
		comboModel = new LocalidadComboModel();
		
		view.getBtnAgregarPersona().addActionListener(e -> crearContacto());
		view.getBtnGuardar().addActionListener(e -> actualizeContacto());
		
	
	}
	
	private void crearContacto(){
		this.personaService.agregar(getNewPersonaDTO());
		this.closeView();
	}
	
	private void actualizeContacto(){
		personaService.actualizePersona(oldPersona, getNewPersonaDTO());
		this.closeView();
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

		comboModel.actualize(localidadService.obtenerAll());
		view.getLocalidadCombo().setModel(comboModel);

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
		
		LocalidadDTO localidad = comboModel.getSelectedLocalidad();
		
		Date cumple = view.getCalendar().getDate();
		
		DomicilioDTO domicilio = new DomicilioDTO(view.getTxtCalle().getText(),
												Integer.getInteger(view.getTxtAltura().getText()),
												Integer.getInteger(view.getTxtPiso().getText()),
												Integer.getInteger(view.getTxtDpto().getText()),
												localidad);
		
		PersonaDTO nuevaPersona = new PersonaDTO(0,this.view.getTxtNombre().getText(),
													view.getTxtTelefono().getText(),
													domicilio,
													cumple,
													view.getTxtEmail().getText());
		
		return nuevaPersona;
	}
	
}
