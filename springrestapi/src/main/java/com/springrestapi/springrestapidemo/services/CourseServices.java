package com.springrestapi.springrestapidemo.services;

import java.util.List;

import com.springrestapi.springrestapidemo.entities.Courses;

public interface CourseServices {
	
	public List<Courses> getCourses();
	
	public Courses getCourse(long courseID);
	
	public Courses addCourse(Courses courses);
	
	public Courses updateCourse(Courses courses);
	
	public void deleteCourse(long parseLong);
	

}
