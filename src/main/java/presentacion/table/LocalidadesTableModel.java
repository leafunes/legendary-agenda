package presentacion.table;

import dto.LocalidadDTO;

public class LocalidadesTableModel extends BaseTableModel<LocalidadDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LocalidadesTableModel() {
		
		addColumn("Nombre", false, 100);
	}
	
	
	@Override
	protected Object[] toRow(LocalidadDTO t) {
		Object[] toRet = {t.getNombre()};
		
		return toRet;
	}
	
	

}
