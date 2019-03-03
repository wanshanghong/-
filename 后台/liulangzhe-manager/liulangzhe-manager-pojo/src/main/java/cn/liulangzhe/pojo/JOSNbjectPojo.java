package cn.liulangzhe.pojo;

import net.sf.json.JSONObject;

public class JOSNbjectPojo {
	private JSONObject json;
	
	public JOSNbjectPojo(User user){
		
	    json = JSONObject.fromObject(user);
		
	}
	
	public JOSNbjectPojo(Post post){
		
	    json = JSONObject.fromObject(post);
		
	}
	public JOSNbjectPojo(String string){
		
	    json = JSONObject.fromObject(string);
		
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
	
      //1、使用JSONObject
	  
//    //2、使用JSONArray
//    JSONArray array=JSONArray.fromObject(stu);
//    
//    String strJson=json.toString();
//    String strArray=array.toString();
//    
//    System.out.println("strJson:"+strJson);
//    System.out.println("strArray:"+strArray);
//}
}
