package mapper;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import model.User;

public interface UserMapper {

	public Integer selectUserCount()throws Exception;
	
	public List<User> selectUsers(JSONObject jsonobject)throws Exception;
	
	public void deleteUser(Integer id)throws Exception;
	
	public void insertUser(User user)throws Exception;
	
	public void updateUser(User user)throws Exception;
}
