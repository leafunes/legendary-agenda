package presentacion.table;

import dto.TipoContactoDTO;

public class TipoContactoTableModel extends BaseTableModel<TipoContactoDTO> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public TipoContactoTableModel() {

        addColumn("Nombre", false, 100);
    }


    @Override
    protected Object[] toRow(TipoContactoDTO t) {
        Object[] toRet = {t.getNombre()};

        return toRet;
    }
}
