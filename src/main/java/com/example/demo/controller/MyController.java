package com.example.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDao;

@Controller
public class MyController {
	
	
	
	@RequestMapping("/")
	String myfun(Model m) {
		
		Student s=new Student();
		
		System.out.println("Data in u object from "+s);
		m.addAttribute("obj",s);
		
		
		return "page1.html";
	}
	
	
	
	@RequestMapping("/data")
	ModelAndView  myfun2(@ModelAttribute("obj") Student s  ) {
		
		//Student s=new Student();
		
		System.out.println("Data in u object from After "+s);
		
		
		System.out.println("Hello");
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao st=context.getBean("d",StudentDao.class);
		
	//	Student s=new Student();
		
		if(st.saveStu(s))
		{
			System.out.println("Data Inserted");
		}
	
		
		
		
		return new ModelAndView("welcome.html").addObject("ob",s);
	}
	

}
