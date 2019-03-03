package cn.liulangzhe.service;

import java.util.List;

import cn.liulangzhe.pojo.Post;
import cn.liulangzhe.pojo.Post_Comment;

public interface PostService {

	//发帖接口
	public Post SendPost(Post post);

	//加载帖接口
	public List<Post> FindAllPost();
	
	//点赞接口
	public Post thumbs_up(int post_id);
	
	//转发接口
	public boolean transmit(int post_id, int userid);
	
	//查找贴(post_id)接口
	public Post FindPostById(int post_id);
	
	//评论帖
	public Post_Comment Comment_post(Post_Comment post_comment);
}
