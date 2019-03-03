package cn.liulangzhe.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liulangzhe.mapper.UserMapper;
import cn.liulangzhe.pojo.User;
import cn.liulangzhe.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	//用户注册
	public boolean registe(User user){
		System.out.println("userService.impl");
		return (userMapper.insertUser(user))>0?true:false;
	}
	
	//用户登陆
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();		
		map.put("username",username);		
		map.put("password", password);		
		return userMapper.login(map);
	}
	
	//查找用户(userid)
	@Override
	public User FindById(int userid) {
		// TODO Auto-generated method stub
		return userMapper.FindById(userid);
	}
	
	//修改用户信息
	@Override
	public boolean Edit_User_Information(User user) {
		// TODO Auto-generated method stub
		return userMapper.Edit_User_Information(user);
	}
}
