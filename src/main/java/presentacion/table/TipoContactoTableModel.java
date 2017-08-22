package presentacion.table;

import dto.TipoContactoDTO;

public class TipoContactoTableModel extends BaseTableModel<TipoContactoDTO> {

    public TipoContactoTableModel() {

        addColumn("Nombre", false, 100);
    }


    @Override
    protected Object[] toRow(TipoContactoDTO t) {
        Object[] toRet = {t.getNombre()};

        return toRet;
    }
}
