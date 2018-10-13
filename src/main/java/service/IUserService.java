package service;

import com.alibaba.fastjson.JSONObject;

import model.User;

public interface IUserService {

	public Integer selectUserCount()throws Exception;
	
	public JSONObject selectUsers(JSONObject jsonobject)throws Exception;
	
	public void deleteUser(Integer id)throws Exception;
	
	public void insertUser(User user)throws Exception;
	
	public void updateUser(User user)throws Exception;
}
