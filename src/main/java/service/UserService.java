package service;


import com.alibaba.fastjson.JSONObject;
import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{

	@Autowired
	UserMapper um;
	
	public Integer selectUserCount() throws Exception {
		
		Integer count = um.selectUserCount();
		
		return count;
	}
	
	
	public JSONObject selectUsers(JSONObject jsonobject) throws Exception {
		
		List<User> list = um.selectUsers(jsonobject);

		Integer count = um.selectUserCount();
		
		jsonobject.put("rows", list);
		
		jsonobject.put("total", count);
		
		System.out.println(jsonobject);
		
		return jsonobject;
	}


	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public void deleteUser(Integer id) throws Exception {
		
		um.deleteUser(id);
		
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public void insertUser(User user) throws Exception {
		
		um.insertUser(user);
		
	}


	
	public void updateUser(User user) throws Exception {
		
		um.updateUser(user);
		
	}

	
}
