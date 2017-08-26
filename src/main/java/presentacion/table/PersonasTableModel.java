package presentacion.table;

import javax.swing.JTable;

import dto.PersonaDTO;

public class PersonasTableModel extends BaseTableModel<PersonaDTO>{

	private static final long serialVersionUID = 1L;
	
	public PersonasTableModel() {
		
		super.addColumn("Tipo Contacto", false, 100);
		super.addColumn("Nombre y Apellido", false, 103);
		super.addColumn("Télefono", false, 100);
		super.addColumn("Domicilio", false, 200);
		super.addColumn("Cumpleaños", false, 75);
		super.addColumn("Email", false, 150);
		
	}
	

	
	@Override
	protected Object[] toRow(PersonaDTO t){
		
		String domicilio = t.getDomicilio().toString();
		
		Object[] fila = {t.getTipo().getNombre(),
						t.getNombre(),
						t.getTelefono(),
						domicilio,
						t.getCumple().toString("dd/MM/YYYY"),
						t.getEmail()};
		
		return fila;
	}

}
