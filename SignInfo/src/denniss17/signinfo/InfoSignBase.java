package denniss17.signinfo;

import java.util.Map;

import org.bukkit.block.Sign;

public abstract class InfoSignBase {
	public int id;
	protected Sign sign;
	protected String type;
	protected String arg1;
	protected String arg2;
	private String cachedLayoutType;
	private String[] cachedLayout;
	protected Map<String, Object> data;

	public InfoSignBase(Sign sign, String type, String arg1, String arg2){
		this.sign = sign;
		this.type = type;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public abstract void updateSign();
	
	public abstract boolean initialize();
	
	public abstract boolean destroy();
	
	public String[] getLayout(){
		if(!cachedLayoutType.equals("default") || cachedLayout==null){
			cachedLayoutType = "default";
			cachedLayout = SignInfo.layoutManager.getLayout(type);
		}
		return cachedLayout;
	}
	
	public String[] getLayout(String subtype){
		if(!cachedLayoutType.equals(subtype) || cachedLayout==null){
			cachedLayoutType = subtype;
			cachedLayout = SignInfo.layoutManager.getLayout(type, subtype);
		}
		return cachedLayout;
	}

	public Sign getSign() {
		return sign;
	}

	public String getType() {
		return type;
	}

	public String getFirstArgument() {
		return arg1;
	}
	
	public String getSecondArgument() {
		return arg2;
	}
	
	public Map<String, Object> getData(){
		return data;
	}
	
	public void setData(Map<String, Object> options){
		this.data = options;
	}
}
