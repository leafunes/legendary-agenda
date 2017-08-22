package presentacion.controlador;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import org.joda.time.DateTime;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import modelo.LocalidadService;
import modelo.PersonaService;
import modelo.TipoContactoService;
import presentacion.combo.LocalidadComboModel;
import presentacion.combo.TipoContactoComboModel;
import presentacion.vista.AgregaPersonaView;

public class AgregaPersonaController {

	private AgregaPersonaView view;
	private PersonaService personaService = PersonaService.getService();
	private LocalidadService localidadService = LocalidadService.getService();
	private TipoContactoService tipoContactoService = TipoContactoService.getService();
	
	private LocalidadComboModel comboModel;
	private TipoContactoComboModel contactoComboModel;
	
	private PersonaDTO oldPersona;
	
	public AgregaPersonaController() {
	
		view = new AgregaPersonaView();
		comboModel = new LocalidadComboModel();
		contactoComboModel = new TipoContactoComboModel();
		
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
		fillCombos();
		
		oldPersona = p;
		
		comboModel.setSelected(p.getDomicilio().getLocalidad());
		contactoComboModel.setSelected(p.getTipo());
		
		view.getCalendar().setDate(DateTime.now().toDate());
		
		view.getTxtAltura().setText(p.getDomicilio().getAltura() + "");
		view.getTxtCalle().setText(p.getDomicilio().getCalle());
		view.getTxtDpto().setText(p.getDomicilio().getDepto() + "");
		view.getTxtEmail().setText(p.getEmail());
		view.getTxtPiso().setText(p.getDomicilio().getPiso() + "");
		view.getTxtNombre().setText(p.getNombre());
		view.getTxtTelefono().setText(p.getTelefono());
		view.getBtnAgregarPersona().setVisible(false);
		view.getBtnGuardar().setVisible(true);
	}
	
	public void agregaPersona(){
		view.setTitle("Agregar Contacto");
		fillCombos();
		
		comboModel.clearSelection();
		contactoComboModel.clearSelection();
		
		view.getCalendar().setDate(DateTime.now().toDate());
		
		view.getTxtAltura().setText("");
		view.getTxtCalle().setText("");
		view.getTxtDpto().setText("");
		view.getTxtEmail().setText("");
		view.getTxtPiso().setText("");
		view.getTxtNombre().setText("");
		view.getTxtTelefono().setText("");
		view.getBtnAgregarPersona().setVisible(true);
		view.getBtnGuardar().setVisible(false);
	}
	
	private void fillCombos(){
		
		comboModel.actualize(localidadService.obtenerAll());
		view.getLocalidadCombo().setModel(comboModel);

		contactoComboModel.actualize(tipoContactoService.obtenerAll());
		view.getTipoCombo().setModel(contactoComboModel);
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
		
		LocalidadDTO localidad = comboModel.getSelected();
		
		DateTime cumple = new DateTime(view.getCalendar().getDate());
		
		System.out.println(view.getTxtAltura().getText());
		
		DomicilioDTO domicilio = new DomicilioDTO(view.getTxtCalle().getText(),
												Integer.parseInt(view.getTxtAltura().getText()),
												Integer.parseInt(view.getTxtPiso().getText()),
												Integer.parseInt(view.getTxtDpto().getText()),
												localidad);
		
		TipoContactoDTO tipo = contactoComboModel.getSelected();
		
		PersonaDTO nuevaPersona = new PersonaDTO(0,this.view.getTxtNombre().getText(),
													view.getTxtTelefono().getText(),
													domicilio,
													cumple,
													view.getTxtEmail().getText(),
													tipo);
		
		return nuevaPersona;
	}
	
}
