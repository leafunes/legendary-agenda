package presentacion.table;

import javax.swing.JTable;

import dto.PersonaDTO;

public class PersonasTableModel extends BaseTableModel<PersonaDTO>{

	private static final long serialVersionUID = 1L;
	
	public PersonasTableModel() {
		
		super.addColumn("Nombre y Apellido", false, 103);
		super.addColumn("Télefono", false, 100);
		
	}
	

	
	@Override
	protected Object[] toRow(PersonaDTO t){
		Object[] fila = {t.getNombre(), t.getTelefono()};
		
		return fila;
	}

}
