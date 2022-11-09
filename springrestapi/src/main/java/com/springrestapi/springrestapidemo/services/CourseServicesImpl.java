package com.springrestapi.springrestapidemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.springrestapidemo.dao.CourseDao;
import com.springrestapi.springrestapidemo.entities.Courses;

@Service
public class CourseServicesImpl implements CourseServices {
	
	@Autowired
	private CourseDao courseDao;
	//List<Courses> list;
	
	public CourseServicesImpl() {
		/*list = new ArrayList<>();
		list.add(new Courses(101, "Core Python Course", "this course is regarding basics of python"));
		list.add(new Courses(102, "Core Java Course", "this course is regarding basics of java"));
		list.add(new Courses(103, "OOPs Course", "this course is regarding OOPs concept"));
		list.add(new Courses(104, "Spring Course", "this course is regarding spring framework"));
		list.add(new Courses(105, "Hibernate Course", "this course is regarding hibernate framework"));*/
		
	}

	
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
	}


	@Override
	public Courses getCourse(long courseID) {
		// TODO Auto-generated method stub
		/*Courses c = null;
		
		for(Courses courses : list) {
			if (courses.getId()== courseID) {
				c=courses;
				break;
			}
		}
		
		return c;*/
		return courseDao.getById(courseID);
	}


	@Override
	public Courses addCourse(Courses courses) {
		// TODO Auto-generated method stub
		/*list.add(courses);*/
		courseDao.save(courses);
		return courses;
	}


	@Override
	public Courses updateCourse(Courses courses) {
		
		/*list.forEach(e -> { //for logic lambda is used
			if(e.getId()==courses.getId()) {
				e.setName(courses.getName());
				e.setDescription(courses.getDescription());
			}
		});*/
		courseDao.save(courses);
		return courses;
	
	}


	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		/*list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());*/
		Courses entity = courseDao.getById(parseLong);
		courseDao.delete(entity);
	}

}
