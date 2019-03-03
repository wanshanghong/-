package cn.liulangzhe.pojo;

import net.sf.json.JSONArray;

public class JOSNArrayPojo {
	
	private JSONArray json;
	
	public JOSNArrayPojo(User user){
			
			json = JSONArray.fromObject(user);
			
		}

	public JSONArray getJson() {
		return json;
	}

	public void setJson(JSONArray json) {
		this.json = json;
	}
	
}
