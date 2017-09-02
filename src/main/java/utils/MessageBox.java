package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessageBox{
	
	static MessageBox singleton;
	private Map<String, List<Runnable>> subscriptores;
	
	public static MessageBox getMessageBox(){
		if(singleton == null){
			singleton = new MessageBox();
		}
		return singleton;
	}
	
	private MessageBox(){
		
		subscriptores = new LinkedHashMap<>();
		
	}
	
	public void suscribirse(String message, Runnable action){
		
		if(!subscriptores.containsKey(message)){
			
			List<Runnable> actions = new ArrayList<>();
			subscriptores.put(message, actions);
			
		}
	
		List<Runnable> actions = subscriptores.get(message);
		actions.add(action);
		subscriptores.put(message, actions);

	}
	
	public void publish(String message){
		if(subscriptores.containsKey(message))
			subscriptores.get(message).forEach(a -> a.run());
	}

}