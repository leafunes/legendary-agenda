package presentacion.controlador;

import modelo.LocalidadService;
import modelo.TipoContactoService;
import presentacion.table.LocalidadesTableModel;
import presentacion.table.TipoContactoTableModel;
import presentacion.vista.ListadoLocalidadesView;
import presentacion.vista.ListadoTipoContactoView;

public class ListadoTipoContactoController {

    private static ListadoTipoContactoController instancia;

    private ListadoTipoContactoView view;
    private AgregaTipoContactoController agregaTipoContactoController;
    private TipoContactoTableModel tipoTableModel;

    private TipoContactoService tipoContactoService = TipoContactoService.getService();

    public static ListadoTipoContactoController getController(){
        if(instancia == null)
            instancia = new ListadoTipoContactoController();
        return instancia;
    }

    private ListadoTipoContactoController(){
        view = new ListadoTipoContactoView();
        agregaTipoContactoController = new AgregaTipoContactoController();
        tipoTableModel = new TipoContactoTableModel();

        view.getBtnAgregar().addActionListener(e -> agregarTipoContacto());
        view.getBtnBorrar().addActionListener(e -> borrarTipoContacto());

    }

    private void agregarTipoContacto(){
        agregaTipoContactoController.showView();
        llenarTabla();
    }

    private void borrarTipoContacto(){

        int[] filas_seleccionadas = this.view.getTable().getSelectedRows();

        for (int fila : filas_seleccionadas){
            this.tipoContactoService.borrar(this.tipoTableModel.getRow(fila));
        }

        this.llenarTabla();

    }

    public void showView(){

        this.llenarTabla();

        this.view.getTable().setModel(tipoTableModel);
        this.view.getTable().setColumnModel(tipoTableModel.getTableColumnModel());
        this.view.getTable().getTableHeader().setReorderingAllowed(false);

        view.setVisible(true);
    }

    private void llenarTabla(){
        this.tipoTableModel.clean();

        this.tipoTableModel.addRows(tipoContactoService.obtenerAll());
    }

    public void closeView(){
        view.dispose();
    }
}
