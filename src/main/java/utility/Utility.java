package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
	
	public static String getData(String key) {
		String srt=null;
		try {
			FileInputStream fis = new FileInputStream(".\\Configuration\\cofig.properties");
			Properties prop = new Properties();
			prop.load(fis);
			srt = prop.getProperty(key);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return srt;
	}
	
	

}
