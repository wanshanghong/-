package cn.liulangzhe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.liulangzhe.pojo.JOSNArrayPojo;
import cn.liulangzhe.pojo.User;
import cn.liulangzhe.service.UserService;
import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//用户注册
	@RequestMapping("/registe.action")
	public String registe(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		User user=new User();
		System.out.println("用户注册功能触发.....请求信息：user:[username:"+username+"    password:"+
				password+"    email:"+email
				+"    phone:"+phone+"]");
		
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		session.setAttribute("user", user);
		System.out.println("userService.registe(user)运行前。。。。。");
		boolean i=userService.registe(user);
		user=(User) session.getAttribute("user");
		System.out.println(user);
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("registe", i);
		return i?"1":"0";
	}
	
	
	//用户登陆
	@RequestMapping("/login.action")
	public void login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("username:"+username+"password"+password);
		User user =new User();
		
		user=userService.login(username,password);
		System.out.println(user);
		session.setAttribute("user", user);
		
		JOSNArrayPojo json =new JOSNArrayPojo(user);
		response.getWriter().write("1");

	}
	
	//查找用户(userid)
	@RequestMapping("FindUserById.action")
	@ResponseBody
	public String FindUserById(@RequestParam("userid")int userid){
		
		System.out.println("查找功能触发.......请求信息：userid="+userid);
		User user=new User();
		user=userService.FindById(userid);
		
		JSONObject json=JSONObject.fromObject(user);
		System.out.println("查找功能结束......响应结果："+json.toString());
		return json.toString();
	}
	
	//修改用户信息
	@RequestMapping("edit_user_information.action")
	@ResponseBody
	public String Edit_User_Information(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, @RequestParam("phone") String phone){
		User user =new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		
		boolean eu=userService.Edit_User_Information(user);
		//Edit_User_Information();
		return "true";
	}
	//测试使用
	@RequestMapping("/login01.action")
	@ResponseBody
	public String login2(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session,HttpServletRequest request,HttpServletResponse response){
		System.out.println("你好"+"username:"+username+"    password:"+password);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", username);
		jsonObj.put("password", password);
		System.out.println("jsonObj"+jsonObj.toString());
		return jsonObj.toString();
	}
}
