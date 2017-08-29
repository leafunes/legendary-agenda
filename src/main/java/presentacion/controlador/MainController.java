package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.PersonaService;
import presentacion.reportes.ReporteAgenda;
import presentacion.table.PersonasTableModel;
import presentacion.vista.AgregaPersonaView;
import presentacion.vista.MainView;
import dto.PersonaDTO;

public class MainController{
		private MainView vista;
		private List<PersonaDTO> personasTabla; 
		private PersonaService agenda;
		private PersonasTableModel tableModel;
		
		private AgregaPersonaController agregaPersonaController;
		private MainViewMenuController menuController;
		
		public MainController(MainView vista, PersonaService agenda)
		{
			this.vista = vista;
			this.tableModel = new PersonasTableModel();
			this.agregaPersonaController = new AgregaPersonaController();
			this.menuController = new MainViewMenuController();
			menuController.init();
			
			this.vista.getBtnAgregar().addActionListener(e -> agregarContacto());
			this.vista.getBtnBorrar().addActionListener(e -> borrarContacto());
			this.vista.getBtnEditar().addActionListener(e -> editarContacto());
			this.vista.getBtnReporte().addActionListener(e -> mostrarReporte());
			
			this.agenda = agenda;
		}
		
		public void showView(){
			this.llenarTabla();
			
			this.vista.getTablaPersonas().setModel(tableModel);
			this.vista.getTablaPersonas().setColumnModel(tableModel.getTableColumnModel());
			this.vista.getTablaPersonas().getTableHeader().setReorderingAllowed(false);
			
			this.vista.show();
		}
		
		private void llenarTabla()
		{
			this.tableModel.clean();
			
			this.personasTabla = agenda.obtenerAll();
			this.tableModel.addRows(personasTabla);
			

		}
		
		private void agregarContacto(){
			this.agregaPersonaController.agregaPersona();
			this.agregaPersonaController.showView();
			this.llenarTabla();
		}
		
		private void borrarContacto(){
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			
			for (int fila : filas_seleccionadas){
				this.agenda.borrar(this.personasTabla.get(fila));
			}
			
			this.llenarTabla();
		}
		
		private void editarContacto(){
			int[] select = this.vista.getTablaPersonas().getSelectedRows();
			
			if(select.length == 1){
				agregaPersonaController.editaPersona(this.tableModel.getRow(select[0]));
				agregaPersonaController.showView();
				this.llenarTabla();
			}
			
		}
		
		private void mostrarReporte(){
			ReporteAgenda reporte = new ReporteAgenda(agenda.getPersonasReporte());
			reporte.mostrar();
		}


}
