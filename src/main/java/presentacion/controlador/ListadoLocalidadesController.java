package presentacion.controlador;

import javax.swing.JOptionPane;

import modelo.LocalidadService;
import presentacion.table.LocalidadesTableModel;
import presentacion.vista.ListadoLocalidadesView;

public class ListadoLocalidadesController {
	
	private static ListadoLocalidadesController instancia;
	
	private ListadoLocalidadesView view;
	private AgregaLocalidadController agregaLocController;
	private LocalidadesTableModel locTableModel;
	
	private LocalidadService localidadService = LocalidadService.getService();
	
	public static ListadoLocalidadesController getController(){
		if(instancia == null)
			instancia = new ListadoLocalidadesController();
		return instancia;
	}
	
	private ListadoLocalidadesController(){
		view = new ListadoLocalidadesView();
		agregaLocController = new AgregaLocalidadController();
		locTableModel = new LocalidadesTableModel();
		
		view.getBtnAgregar().addActionListener(e -> agregarLocalidad());
		view.getBtnBorrar().addActionListener(e -> borrarLocalidad());
		
	}
	
	private void agregarLocalidad(){
		agregaLocController.showView();
		llenarTabla();
	}
	
	private void borrarLocalidad(){
		
		int[] seleccionadas = this.view.getTable().getSelectedRows();
		
        for (int fila : seleccionadas){
        	if(localidadService.existsPersonaWith(this.locTableModel.getRow(fila))){
        		JOptionPane.showMessageDialog(view, "La localidad " 
        										+ this.locTableModel.getRow(fila).getNombre() 
        										+ " tiene asociada a una persona",
        										"Error al borrar",
        										JOptionPane.ERROR_MESSAGE);
        	return;	
        	}
        }
		
		for (int fila : seleccionadas){
			this.localidadService.borrar(this.locTableModel.getRow(fila));
		}
		
		this.llenarTabla();
		
	}
	
	public void showView(){
		
		this.llenarTabla();
		
		this.view.getTable().setModel(locTableModel);
		this.view.getTable().setColumnModel(locTableModel.getTableColumnModel());
		this.view.getTable().getTableHeader().setReorderingAllowed(false);
		
		view.setVisible(true);
	}
	
	private void llenarTabla(){
		this.locTableModel.clean();
		this.locTableModel.addRows(localidadService.obtenerAll());
	}
	
	public void closeView(){
		view.dispose();
	}

}
