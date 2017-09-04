package presentacion.controlador;

import javax.swing.JOptionPane;

import dto.LocalidadDTO;
import modelo.LocalidadService;
import presentacion.vista.AgregaLocalidadView;

public class AgregaLocalidadController {

	private AgregaLocalidadView view;
	private LocalidadService localidadService = LocalidadService.getService();
	
	
	public AgregaLocalidadController() {
	
		view = new AgregaLocalidadView();
		
		view.getBtnAgregar().addActionListener(e -> crearLocalidad());
	
	}
	
	private void crearLocalidad(){
		if(isFieldsOk()){
			this.localidadService.agregar(getNewLocalidadDTO());
			this.closeView();
		}
	}
	
	
	public void showView(){
		
		view.setVisible(true);
	}
	
	private boolean isFieldsOk(){
		if(view.getTxtNombre().getText().isEmpty()){
			JOptionPane.showMessageDialog(view, "El nombre no puede ser vacio", "Error", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;
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
