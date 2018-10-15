package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import model.User;
import service.IUserService;

	

@Controller
public class UserController {

	@Autowired
	IUserService ius;
	
	@RequestMapping(value="/toindex",method=RequestMethod.GET)
	public String toindex(){
		System.out.println();
		return "index";
	}
	
	@RequestMapping(value="/{path}",method=RequestMethod.GET)
	public String todatatable(@PathVariable String path){

		return path;
	}
	
	@RequestMapping(value="/userlist",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getlistuser(@RequestBody JSONObject jsonobject) throws Exception{
	
		JSONObject object = ius.selectUsers(jsonobject);
		
		
		return object;
	}
	
	
	@RequestMapping(value="/deleteuser",method=RequestMethod.POST)
	public void deleteuser(Integer id) throws Exception{
		
		ius.deleteUser(id);
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public void adduser(User user) throws Exception{
		
		ius.insertUser(user);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public void updateuser(User user) throws Exception{
		
		ius.updateUser(user);
	}
}
