package com.apps.studentEnrollmentManagementBackEndApp.service;

import java.util.List;

import com.apps.studentEnrollmentManagementBackEndApp.beans.CourseEnrolled;

public interface CourseEnrolledService {
	public CourseEnrolled saveCourseEnrolled(CourseEnrolled courseEnrolled);
	public CourseEnrolled getCourseEnrolledById(long courseEnrolledId);
	public CourseEnrolled deleteCourseEnrolled(long courseEnrolledId);
	public CourseEnrolled updateCourseEnrolled(CourseEnrolled courseEnrolled);
	public List<CourseEnrolled> getCourseEnrolled();
}
