package presentacion.controlador;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Binder<T> {
	
	enum Condition{STRVOIDISNULL};
	
	private Map<String, Supplier<Object>> bindings;
	private Map<String, Condition> conditions;
	private T objective;

	public Binder() {
		bindings = new HashMap<>();
	}
	
	public void setObjective(T objective){
		this.objective = objective;
	}
	
	public void bind(String campo, Supplier<Object> getter){
		
		bindings.put(campo, getter);
		
	}
	
	public void commit(){
		
		for(String s : bindings.keySet()){
			
			String[] fields = s.split("\\.");
			
			try {
				
				setField(s, fields, objective, 0);
				
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void setField(String key, String[] fields, Object o, int i) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{

		
		Field f = o.getClass().getDeclaredField(fields[i]);
		if(!f.isAccessible()) f.setAccessible(true);

		if(fields.length == i + 1){
			f.set(o, bindings.get(key).get());
		}
		else{
			Object o2 = f.get(o);
			setField(key,fields, o2, i + 1);
		}
		
	}
	
}
