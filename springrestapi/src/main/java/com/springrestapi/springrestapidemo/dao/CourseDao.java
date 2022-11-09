package com.springrestapi.springrestapidemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.springrestapidemo.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long> {

}
