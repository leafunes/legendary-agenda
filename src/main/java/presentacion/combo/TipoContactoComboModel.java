package presentacion.combo;

import java.util.List;

import dto.TipoContactoDTO;

public class TipoContactoComboModel extends BaseComboBoxModel<TipoContactoDTO>{

	@Override
	public void actualize(List<TipoContactoDTO> list) {
		this.removeAllElements();
		
		list.forEach(l -> this.addElement(l.getNombre()));
		list.forEach(l -> values.put(l.getNombre(), l));
		
	}

	@Override
	public void setSelected(TipoContactoDTO toSelect) {
		
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		
		else{
			
		String nombre = toSelect.getNombre();
		
		this.setSelectedItem(nombre);

		}
		
	}
	
	

}
