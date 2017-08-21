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

public class MainViewController{
		private MainView vista;
		private List<PersonaDTO> personasTabla;
		private AgregaPersonaView ventanaPersona; 
		private PersonaService agenda;
		private PersonasTableModel tableModel;
		
		public MainViewController(MainView vista, PersonaService agenda)
		{
			this.vista = vista;
			this.tableModel = new PersonasTableModel();
			
			this.vista.getBtnAgregar().addActionListener(e -> agregarContacto());
			this.vista.getBtnBorrar().addActionListener(e -> borrarContacto());
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
			this.ventanaPersona = new AgregaPersonaView();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(e -> crearContacto());
		}
		
		private void borrarContacto(){
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			
			for (int fila : filas_seleccionadas){
				this.agenda.borrar(this.personasTabla.get(fila));
			}
			
			this.llenarTabla();
		}
		
		private void mostrarReporte(){
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerAll());
			reporte.mostrar();
		}
		
		private void crearContacto(){
			this.agenda.agregar(getNewPersonaDTO());
			this.llenarTabla();
			this.ventanaPersona.dispose();
		}
		

		private PersonaDTO getNewPersonaDTO(){
			PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText());
			
			return nuevaPersona;
		}

}
