package mx.com.avior.controller;

import javax.servlet.http.HttpServletRequest;


import mx.com.avior.dbacces.ValidaLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
	@Autowired
	private ValidaLogin usuario; 
	
	@RequestMapping("/index")
	public ModelAndView peticionLogueo(HttpServletRequest request)
	{
		
		return new ModelAndView("Index");
	}
	
}
