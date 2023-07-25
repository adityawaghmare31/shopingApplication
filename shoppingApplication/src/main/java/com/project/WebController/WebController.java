package com.project.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.Dao.UserDao;
import com.project.Entity.User;


public class WebController {
	
	@Autowired
	UserDao userDao;
	
	ModelAndView mv=new ModelAndView();
	
	@RequestMapping("/a")
	public String login() {
		return "login";
		
	}
	

	@RequestMapping("validate")
	public ModelAndView validate(User userFromBrowser) {
		
		ModelAndView mv=new ModelAndView();
		User userFromDatabase=userDao.ValideUser(userFromBrowser);
		
	//	User userFromDatabase=.get(User.class, userFromBrowser.getUsername());
		
		//userFromDatabase==>[username="java" password="java123"] user class object
		// get() gives null if record is not found in database
		if(userFromDatabase!=null) 
		{
			if(userFromBrowser.getPassword().equals(userFromDatabase.getPassword())) {
				mv.addObject("username",userFromBrowser.getUsername());
				mv.setViewName("welcome");
				}
			else
			{
				mv.addObject("massage","wrong password");
				mv.setViewName("login");
			}
		}
		else 
		{
			mv.addObject("massage","wrong username");
			mv.setViewName("login");
		}
		return mv;
		
		
	} 
	
	
	@RequestMapping("showregister")
		String showregister() {
			return "register";
		}
	
	
	@RequestMapping("savadata")
	
	ModelAndView savedata(User save) {
		String string=userDao.savedata(save);
		mv.addObject("massage", "Registration successful");
		mv.setViewName("login");
		return mv;
	}
		
		
	
}
