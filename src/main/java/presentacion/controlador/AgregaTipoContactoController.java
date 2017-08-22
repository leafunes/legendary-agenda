package presentacion.controlador;

import javax.swing.JOptionPane;

import dto.TipoContactoDTO;
import modelo.TipoContactoService;
import presentacion.vista.AgregaTipoContactoView;

public class AgregaTipoContactoController {

    private AgregaTipoContactoView view;
    private TipoContactoService tipoContactoService = TipoContactoService.getService();

    public AgregaTipoContactoController() {

        view = new AgregaTipoContactoView();

        view.getBtnAgregar().addActionListener(e -> crearTipoContacto());

    }

    private void crearTipoContacto(){
        if(isFieldsOk()){
        	this.tipoContactoService.agregar(getNewTipoContactoDTO());
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

    private TipoContactoDTO getNewTipoContactoDTO(){
        TipoContactoDTO nuevoTipoContacto = new TipoContactoDTO(0,this.view.getTxtNombre().getText());

        return nuevoTipoContacto;
    }


}
