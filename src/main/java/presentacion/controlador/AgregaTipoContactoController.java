package presentacion.controlador;

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
        this.tipoContactoService.agregar(getNewTipoContactoDTO());
        this.closeView();
    }


    public void showView(){
        view.setVisible(true);
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
