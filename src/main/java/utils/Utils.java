package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class Utils {
	
	private static Utils instancia;
	
	public static Utils getUtils(){
		if(instancia == null)
			instancia = new Utils();
		return instancia;
	}
	
	private Utils(){
		
	}
	
	public boolean isFirstBoot() throws FileNotFoundException, IOException{
		
		Properties props = new Properties();
		
		props.load(new FileInputStream(new File("config.properties")));
		
		String isFirst = props.getProperty("isFirst");
		
		if(isFirst == null){
			props.setProperty("isFirst", "true");
			props.store(new FileOutputStream(new File("config.properties")), null);
			return true;
		}
		
		return isFirst.equals("true");
		
	}

	public void setFirstTimeFalse() {
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream(new File("config.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String isFirst = props.getProperty("isFirst");
		
		props.setProperty("isFirst", "false");
		try {
			props.store(new FileOutputStream(new File("config.properties")), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
