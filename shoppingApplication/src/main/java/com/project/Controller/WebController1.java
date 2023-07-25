package com.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController1 {
	
	
	@RequestMapping("/")
	public String apicall()	
	{
		return "apicall";
	}
	
	

}
