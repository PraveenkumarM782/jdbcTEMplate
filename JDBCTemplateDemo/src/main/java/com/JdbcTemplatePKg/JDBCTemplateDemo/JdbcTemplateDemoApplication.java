package com.JdbcTemplatePKg.JDBCTemplateDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JdbcTemplatePKg.JDBCTemplateDemo.entity.Course;
import com.JdbcTemplatePKg.JDBCTemplateDemo.entity.CourseJdbcDAO;

@SpringBootApplication
public class JdbcTemplateDemoApplication {

	private static CourseJdbcDAO dao;
	
	
	public JdbcTemplateDemoApplication(CourseJdbcDAO dao) {
		this.dao=dao;
	}


	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateDemoApplication.class, args);
		
		
		System.out.println("----Get all Courses-------");
		
		System.out.println(dao.getCourseslist()); 
		
		System.out.println("-------Get courses-----------");
		
		//System.out.println(dao.getCourse(444));
		System.out.println(dao.getCourse(555));
		
//    	System.out.println("-------------create COURSE----------");
//		Course c = new Course(22,"english","spoken","dummy******link");
//		dao.create(c);
		
		
		
//		System.out.println("-------------update COURSE----------");
//		Course c1 = new Course(22,"Advance english","spokenupdate","new Dummy link");
//		dao.update(c1, 22);
		
		
		System.out.println("-------------delete COURSE----------");
		dao.delete(22);
		
	}

}
