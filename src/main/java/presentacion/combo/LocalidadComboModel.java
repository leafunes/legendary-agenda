package presentacion.combo;

import java.util.List;

import dto.LocalidadDTO;

public class LocalidadComboModel extends BaseComboBoxModel<LocalidadDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void actualize(List<LocalidadDTO> list){
		this.removeAllElements();
		
		list.forEach(l -> this.addElement(l.getNombre()));
		list.forEach(l -> values.put(l.getNombre(), l));
	}

	@Override
	public void setSelected(LocalidadDTO toSelect) {
		
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.getNombre();
		
		this.setSelectedItem(nombre);
		
		}
		
	}

}
