package presentacion.table;

import dto.LocalidadDTO;

public class LocalidadesTableModel extends BaseTableModel<LocalidadDTO>{

	public LocalidadesTableModel() {
		
		addColumn("Nombre", false, 100);
	}
	
	
	@Override
	protected Object[] toRow(LocalidadDTO t) {
		Object[] toRet = {t.getNombre()};
		
		return toRet;
	}
	
	

}
