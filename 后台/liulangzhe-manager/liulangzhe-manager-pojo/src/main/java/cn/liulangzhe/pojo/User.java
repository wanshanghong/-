package cn.liulangzhe.pojo;

public class User {
	private int userid;
	private String username;
	private String password;
	private String email;
	private String phone;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user:[userid:"+userid+"    username:"+username+"    password:"+
				password+"    email:"+email
				+"    phone:"+phone+"]";
	}
	
}
