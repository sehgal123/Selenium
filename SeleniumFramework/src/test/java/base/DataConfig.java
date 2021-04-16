package base;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class DataConfig {

	private static DataConfig instance;
	private static Map<String,Object> propertiesData= new HashMap<String,Object>();
	private static Map<String,Object> moduleMapData=Collections.unmodifiableMap(propertiesData);
	private static String previousFilePath;	

	public static DataConfig getInstance(String filePath)
	{
		if(previousFilePath==null || !filePath.equals(previousFilePath))
		{
			instance=new DataConfig(filePath);
			previousFilePath=filePath;
		}
		return instance;
	}
	
	private DataConfig(String property) {
		Properties properties=null;
		try {
			properties= new Properties();
			FileInputStream config_ip = new FileInputStream(property);
			properties.load(config_ip);
			//properties.load(DataConfig.class.getResourceAsStream(property));
			propertiesData.putAll(properties.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
		}
		catch(Exception e)
		{
			properties=null;
		}
	}
	
	private DataConfig() {
		
	}
	
	static DataConfig getInstance()
	{
		if(instance==null)
		{
			instance= new DataConfig();
		}
		return instance;
	}
	
	public String getProperty(String key)
	{
		return moduleMapData.get(key).toString();
	}
}
