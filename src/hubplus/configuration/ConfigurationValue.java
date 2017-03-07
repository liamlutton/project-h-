package hubplus.configuration;

public class ConfigurationValue {

	private String id;
	private Object value;
	
	public ConfigurationValue(String id, Object value){
		this.id = id;
		this.value = value;
	}
	
	public String getId(){
		return id;
	}
	
	public Object getValue(){
		return value;
	}
	
}
