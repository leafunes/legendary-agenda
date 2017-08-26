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
	
	private PersonaDTO currentPersona;
	
	private Binder<PersonaDTO> binder;
	
	public AgregaPersonaController() {
	
		view = new AgregaPersonaView();
		comboModel = new LocalidadComboModel();
		contactoComboModel = new TipoContactoComboModel();
		binder = new Binder<>();
		
		binder.bind("nombre", 
				view.getTxtNombre()::getText,
				t -> view.getTxtNombre().setText((String)t));
		
		binder.bind("telefono",
				view.getTxtTelefono()::getText, 
				t -> view.getTxtTelefono().setText((String)t));
		
		binder.bind("cumple", 
				() -> new DateTime(view.getCalendar().getDate()),
				d -> view.getCalendar().setDate(((DateTime)d).toDate()));
		
		binder.bind("email", 
				view.getTxtEmail()::getText,
				t -> view.getTxtEmail().setText((String)t));
		
		binder.bind("tipo",
				contactoComboModel::getSelected,
				t -> contactoComboModel.setSelected((TipoContactoDTO)t));
		
		binder.bind("domicilio.calle",
				view.getTxtCalle()::getText,
				t -> view.getTxtCalle().setText((String)t));
		
		binder.bind("domicilio.altura",
				view.getTxtAltura()::getText,
				t -> view.getTxtAltura().setText((String)t));
		
		binder.bind("domicilio.piso",
				view.getTxtPiso()::getText,
				t -> view.getTxtPiso().setText((String)t));
		
		binder.bind("domicilio.depto",
				view.getTxtDpto()::getText,
				t -> view.getTxtDpto().setText((String)t));
		
		binder.bind("domicilio.localidad",
				comboModel::getSelected,
				l -> comboModel.setSelected((LocalidadDTO)l));
		
		view.getBtnAgregarPersona().addActionListener(e -> crearContacto());
		view.getBtnGuardar().addActionListener(e -> actualizeContacto());
		
	
	}
	
	private void crearContacto(){
		if(fieldsOk()){
			binder.fillBean();
			this.personaService.agregar(currentPersona);
			this.closeView();
		}
	}
	
	private void actualizeContacto(){
		if(fieldsOk()){
			binder.fillBean();
			personaService.actualizePersona(currentPersona);
			this.closeView();
		}
	}


	public void editaPersona(PersonaDTO p){
		view.setTitle("Editar Contacto");
		view.getBtnAgregarPersona().setVisible(false);
		view.getBtnGuardar().setVisible(true);
		fillCombos();
		
		currentPersona = p;
		binder.setObjective(currentPersona);
		binder.fillFields();
	}
	
	public void agregaPersona(){
		view.setTitle("Agregar Contacto");
		view.getBtnAgregarPersona().setVisible(true);
		view.getBtnGuardar().setVisible(false);
		fillCombos();

		createNewPersona();
		binder.fillFields();
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
	
	private void createNewPersona(){
		
		DomicilioDTO domicilio = new DomicilioDTO();
		
		PersonaDTO nuevaPersona = new PersonaDTO();
		
		nuevaPersona.setDomicilio(domicilio);
		nuevaPersona.setCumple(DateTime.now());
		
		currentPersona = nuevaPersona;
		
		binder.setObjective(currentPersona);
	}

	
}
