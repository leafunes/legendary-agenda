package presentacion.controlador;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

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
		if(fieldsOk()){
			this.personaService.agregar(getNewPersonaDTO());
			this.closeView();
		}
	}
	
	private void actualizeContacto(){
		if(fieldsOk()){
			personaService.actualizePersona(oldPersona, getNewPersonaDTO());
			this.closeView();
		}
	}
	
	public void editaPersona(PersonaDTO p){
		view.setTitle("Editar Contacto");
		fillCombos();
		
		oldPersona = p;
		
		comboModel.setSelected(p.getDomicilio().getLocalidad());
		contactoComboModel.setSelected(p.getTipo());
		
		view.getCalendar().setDate(DateTime.now().toDate());
		
		String deptoStr = p.getDomicilio().getDepto() == null? "" : p.getDomicilio().getDepto().toString();
		String pisoStr = p.getDomicilio().getPiso() == null? "" : p.getDomicilio().getPiso().toString();
		
		view.getTxtAltura().setText(p.getDomicilio().getAltura() + "");
		view.getTxtCalle().setText(p.getDomicilio().getCalle());
		view.getTxtDpto().setText(deptoStr);
		view.getTxtEmail().setText(p.getEmail());
		view.getTxtPiso().setText(pisoStr);
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
	
	private boolean fieldsOk(){
		
		boolean emptys = view.getTxtNombre().getText().isEmpty();
		emptys |= view.getTxtTelefono().getText().isEmpty();
		emptys |= view.getTxtCalle().getText().isEmpty();
		emptys |= view.getTxtAltura().getText().isEmpty();
		
		if(emptys){
			JOptionPane.showMessageDialog(view, "Hay campos obligatorios que estan vacios",
											"Error",
											JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!view.getTxtEmail().getText().matches("([A-Z|a-z|0-9](\\.|_){0,1})+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.){0,1}[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}")){

			JOptionPane.showMessageDialog(view, "El email no es válido",
											"Error",
											JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!view.getTxtAltura().getText().matches("[0-9]*")){

			JOptionPane.showMessageDialog(view, "La altura debe ser un número",
											"Error",
											JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!view.getTxtDpto().getText().matches("[0-9]*")){

			JOptionPane.showMessageDialog(view, "El departamento debe ser un número",
											"Error",
											JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!view.getTxtPiso().getText().matches("[0-9]*")){

			JOptionPane.showMessageDialog(view, "El piso debe ser un número",
											"Error",
											JOptionPane.ERROR_MESSAGE);
			return false;
		}
			
			
		return true;
		
	}
	
	private PersonaDTO getNewPersonaDTO(){
		
		LocalidadDTO localidad = comboModel.getSelected();
		
		DateTime cumple = new DateTime(view.getCalendar().getDate());
		
		Integer detpo = view.getTxtDpto().getText().isEmpty()? null:Integer.parseInt(view.getTxtDpto().getText());
		Integer piso = view.getTxtPiso().getText().isEmpty()? null:Integer.parseInt(view.getTxtPiso().getText());
		
		DomicilioDTO domicilio = new DomicilioDTO(view.getTxtCalle().getText(),
												Integer.parseInt(view.getTxtAltura().getText()),
												detpo,
												piso,
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
