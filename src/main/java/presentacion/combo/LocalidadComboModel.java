package presentacion.combo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;

import dto.LocalidadDTO;

public class LocalidadComboModel extends BaseComboBoxModel<LocalidadDTO>{
	
	public void actualize(List<LocalidadDTO> list){
		this.removeAllElements();
		
		list.forEach(l -> this.addElement(l.getNombre()));
		list.forEach(l -> values.put(l.getNombre(), l));
	}

	@Override
	public void setSelected(LocalidadDTO toSelect) {
		
		String nombre = toSelect.getNombre();
		
		this.setSelectedItem(nombre);
		
	}

}
