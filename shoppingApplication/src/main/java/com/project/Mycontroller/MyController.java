package com.project.Mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("hello")
	public String hello() {
		return "hello";
		
	}


@RequestMapping("hi")
public String hi() {
	return "hi";
	}
}
