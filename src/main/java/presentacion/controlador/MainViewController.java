package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.AgregaPersonaView;
import presentacion.vista.MainView;
import dto.PersonaDTO;

public class MainViewController{
		private MainView vista;
		private List<PersonaDTO> personasTabla;
		private AgregaPersonaView ventanaPersona; 
		private Agenda agenda;
		
		public MainViewController(MainView vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(e -> agregarContacto());
			this.vista.getBtnBorrar().addActionListener(e -> borrarContacto());
			this.vista.getBtnReporte().addActionListener(e -> mostrarReporte());
			this.agenda = agenda;
		}
		
		public void inicializar()
		{
			this.llenarTabla();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			
			this.personasTabla = agenda.obtenerPersonas();
			
			for(PersonaDTO p : this.personasTabla){
				this.vista.getModelPersonas().addRow(toRow(p));
			}
			this.vista.show();
		}
		
		private void agregarContacto(){
			this.ventanaPersona = new AgregaPersonaView();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(e -> crearContacto());
		}
		
		private void borrarContacto(){
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			
			for (int fila : filas_seleccionadas){
				this.agenda.borrarPersona(this.personasTabla.get(fila));
			}
			
			this.llenarTabla();
		}
		
		private void mostrarReporte(){
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		}
		
		private void crearContacto(){
			this.agenda.agregarPersona(getNewPersonaDTO());
			this.llenarTabla();
			this.ventanaPersona.dispose();
		}
		

		private Object[] toRow(PersonaDTO p){
			Object[] fila = {p.getNombre(), p.getTelefono()};
			
			return fila;
		}
		
		private PersonaDTO getNewPersonaDTO(){
			PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText());
			
			return nuevaPersona;
		}

}
