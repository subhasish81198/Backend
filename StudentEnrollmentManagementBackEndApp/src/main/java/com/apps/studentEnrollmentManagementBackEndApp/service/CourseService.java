package com.apps.studentEnrollmentManagementBackEndApp.service;

import java.util.List;

import com.apps.studentEnrollmentManagementBackEndApp.beans.Course;

public interface CourseService {
	public Course saveCourse(Course course);
	public Course getCourseById(long courseId);
	public Course deleteCourse(long courseId);
	public Course updateCourse(Course course);
	public List<Course> getCourse();

}
