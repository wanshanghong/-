package cn.liulangzhe.pojo;

public class Post_Comment {
	private int post_id;
	private int commentator_id;
	private String comment_content;
	private int praise_amount;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getCommentator_id() {
		return commentator_id;
	}
	public void setCommentator_id(int commentator_id) {
		this.commentator_id = commentator_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getPraise_amount() {
		return praise_amount;
	}
	public void setPraise_amount(int praise_amount) {
		this.praise_amount = praise_amount;
	}
	
	
}
