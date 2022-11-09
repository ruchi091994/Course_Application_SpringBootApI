package com.springrestapi.springrestapidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.springrestapidemo.entities.Courses;
import com.springrestapi.springrestapidemo.services.CourseServices;

@RestController //Representational state transfer
public class MyController {
	
	@Autowired // to create an object from an interface
	private CourseServices courseServices;
	
	
	public MyController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	//get the course
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		
		return this.courseServices.getCourses();
	}
	
	//get sincgle course by ID
	@GetMapping("/courses/{courseID}")
	public Courses getCourse(@PathVariable String courseID) {
		return this.courseServices.getCourse(Long.parseLong(courseID));
	}
	
	//add course to the list
	@PostMapping("/courses")
	public Courses addCourse( @RequestBody Courses courses) {
		return this.courseServices.addCourse(courses);
	}
	
	//updating single course
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses courses) {
		return this.courseServices.updateCourse(courses);
	}
	
	
	//delete the course
	@DeleteMapping("/courses/{courseID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID) {
		
		try {
			this.courseServices.deleteCourse(Long.parseLong(courseID));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
