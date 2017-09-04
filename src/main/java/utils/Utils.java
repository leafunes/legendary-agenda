package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	
	private static Utils instancia;
	private static File propsFile = new File("config" + File.separatorChar + "config.properties");
	
	public static Utils getUtils(){
		if(instancia == null)
			instancia = new Utils();
		return instancia;
	}
	
	private Utils(){
		
	}
	
	public boolean isFirstBoot() throws FileNotFoundException, IOException{
		
		Properties props = new Properties();
		
		props.load(new FileInputStream(propsFile));
		
		String isFirst = props.getProperty("isFirst");
		
		if(isFirst == null){
			props.setProperty("isFirst", "true");
			props.store(new FileOutputStream(propsFile), null);
			return true;
		}
		
		return isFirst.equals("true");
		
	}

	public void setFirstTimeFalse() {
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream(propsFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		props.setProperty("isFirst", "false");
		try {
			props.store(new FileOutputStream(propsFile), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
