package cn.liulangzhe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.liulangzhe.pojo.JOSNbjectPojo;
import cn.liulangzhe.pojo.Post;
import cn.liulangzhe.pojo.Post_Comment;
import cn.liulangzhe.pojo.User;
import cn.liulangzhe.service.PostService;
import cn.liulangzhe.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PostController{
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	
		//发帖1
		@RequestMapping("/sendpost1.action")
		@ResponseBody
		public String sendpost1(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
			System.out.println("出事了");
			MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);            
			MultipartFile imgfile1 = ((MultipartHttpServletRequest) request).getFile("filepic");
			String post_name=params.getParameter("title");
			String post_content=params.getParameter("content");
			System.out.println("post_name:"+post_name);      
			System.out.println("post_content:"+post_content);            
			MultipartFile file = null;    

			Post post=new Post();
			
			post.setPost_name(post_name);
			post.setPost_content(post_content);
			
			//上传图片
			//获得物理路径webapp所在路径
			String pathRoot = request.getSession().getServletContext().getRealPath("");
			String path1="";
			if(!imgfile1.isEmpty()){
				//生成uuid作为文件名称
				String uuid = UUID.randomUUID().toString().replaceAll("-","");
				//获得文件类型（可以判断如果不是图片，禁止上传）			
				String contentType=imgfile1.getContentType();
				//获得文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
				path1="/static/images/"+uuid+"."+imageName;
				imgfile1.transferTo(new File(pathRoot+path1));
				}
			post.setImg_path1(path1);
			System.out.println(path1);	

			//获取当前时间
			Date date=new Date();
			post.setPost_date(date);
			System.out.println("当前时间："+date);
			
			//获取发帖人
			User user=new User();
			user=(User) session.getAttribute("user");
			post.setSender_name(user.getUsername());
			
			post=postService.SendPost(post);
			
			JOSNbjectPojo json=new JOSNbjectPojo(post);
			
//			response.getWriter().write(json.getJson().toString());
			return json.getJson().toString();
		}
	
	//发帖
	@RequestMapping("/sendpost.action")
	@ResponseBody
	public void sendpost(@RequestParam("post_name") int post_name,@RequestParam(value="imgfile",required=false) MultipartFile imgfile,
			@RequestParam(value="videofile",required=false) MultipartFile videofile,@RequestParam("post_content") String post_content,
			HttpServletRequest request,HttpServletResponse response,
			HttpSession session
			) throws IOException{
		
		
		Post post=new Post();
		
		post.setPost_id(post_name);
		post.setPost_content(post_content);
		
		//上传图片
		//获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path1="";
		if(!imgfile.isEmpty()){
			//生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//获得文件类型（可以判断如果不是图片，禁止上传）			
			String contentType=imgfile.getContentType();
			//获得文件后缀名称
			String imageName=contentType.substring(contentType.indexOf("/")+1);
			path1="/static/images/"+uuid+"."+imageName;
			imgfile.transferTo(new File(pathRoot+path1));
			}
		post.setImg_path1(path1);
		System.out.println(path1);		
		request.setAttribute("imagesPath", path1);
		
		//上传视频
		String path2="";
		if(!videofile.isEmpty()){
			//生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//获得文件类型（可以判断如果不是图片，禁止上传）			
			String contentType=videofile.getContentType();
			//获得文件后缀名称
			String videoName=contentType.substring(contentType.indexOf("/")+1);
			path2="/static/videos/"+uuid+"."+videoName;
			imgfile.transferTo(new File(pathRoot+path2));
			}
		post.setVideo_path(path2);
		System.out.println(path2);		
		request.setAttribute("videoPath", path2);
			
		request.setAttribute("videoPath", path2);
		//获取当前时间
		Date date=new Date();
		post.setPost_date(date);
		System.out.println("当前时间："+date);
		
		post=postService.SendPost(post);
		
		JOSNbjectPojo json=new JOSNbjectPojo(post);
		
		response.getWriter().write(json.getJson().toString());
		
	}
	
	
	//加载所有的帖
	@RequestMapping("loadAllPost.action")
	@ResponseBody
	public String loadAllPost(HttpServletRequest request,HttpServletResponse response,
			HttpSession session) throws IOException{
		System.out.println("加载所有帖功能触发......请求信息：无");
		List<Post> list=new ArrayList<Post>();
		list=postService.FindAllPost();
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println("加载所有帖功能结束......回应信息：post："+jsonArray.toString());
		return jsonArray.toString();

	}
	
	//点赞功能
	@RequestMapping("thumbs-up.action")
	@ResponseBody
	public String thumbs_up(@RequestParam("post_id") int post_id,HttpSession session){
		
		System.out.println("点赞功能触发......请求信息：post_id="+post_id);
		Post post=new Post();
		post=postService.thumbs_up(post_id);
		
		JSONObject json=JSONObject.fromObject(post);
		System.out.println("点赞功能结束......回应信息：post："+json.toString());
		return json.toString();
	}
	
	//转发功能
	@RequestMapping("transmit.action")
	@ResponseBody
	public String transmit(@RequestParam("post_id") int post_id,@RequestParam("userid") int userid){
		System.out.println("转发功能触发......请求信息：post_id="+post_id+"\t userid:"+userid);
		boolean tm=postService.transmit(post_id,userid);
		if(tm==true){
			Map<Object, Object> map = new HashMap<Object, Object>(); 
			
			User user=new User();
			user=userService.FindById(userid);
			Post post=new Post();
			post=postService.FindPostById(post_id);
			map.put("user", user);
			map.put("post", post);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("点赞功能结束......回应信息：post："+jsonObject.toString());
			return jsonObject.toString();
		}else
			return "转发失败！";
	}
	
	//评论功能
	@RequestMapping("comment_post.action")
	@ResponseBody
	public String comment_post(@RequestParam("post_id")int post_id,@RequestParam("commentator_id")int commentator_id,
			@RequestParam("comment_content") String comment_content){
		System.out.println("评论功能触发......请求信息：post_id="+post_id+"\t comment_context:"+comment_content+"\t commentator_id:"+commentator_id);
		Post_Comment post_comment=new Post_Comment();
		post_comment.setComment_content(comment_content);
		post_comment.setPost_id(post_id);
		post_comment.setCommentator_id(commentator_id);
		
		post_comment=postService.Comment_post(post_comment);
		JSONObject jsonObject = JSONObject.fromObject(post_comment);
		System.out.println("点赞功能结束......回应信息：post："+jsonObject.toString());
		return jsonObject.toString();
	}
}
