package cn.liulangzhe.mapper;

import java.util.List;
import java.util.Map;

import cn.liulangzhe.pojo.Post;
import cn.liulangzhe.pojo.Post_Comment;

public interface PostMapper {
	//发帖上传图片
	public int PostInsert(Post post);
	
	//ID查帖
	public Post SelectIdPost(int post_id);
	
	//加载所有的帖
	public List<Post> FindAllPost();

	//点赞
	public Post thumbs_up(int post_id);
	
	//转发功能
	public int transmit(Map<Object, Object> map);

	//查找贴(post_id)
	public Post FindPostById(int post_id);
	
	//评论帖
	public Post_Comment Comment_post(Post_Comment post_comment);
}
