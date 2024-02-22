package com.apps.studentEnrollmentManagementBackEndApp.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long courseId;
private String courseName;
private Double coursefee;
private Integer courseDuration;
public Course() {
	super();
	
}
public Course( String courseName, Double coursefee, Integer courseDuration) {
	super();
	
	this.courseName = courseName;
	this.coursefee = coursefee;
	this.courseDuration = courseDuration;
}
public Long getCourseId() {
	return courseId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public Double getCoursefee() {
	return coursefee;
}
public void setCoursefee(Double coursefee) {
	this.coursefee = coursefee;
}
public Integer getCourseDuration() {
	return courseDuration;
}
public void setCourseDuration(Integer courseDuration) {
	this.courseDuration = courseDuration;
}
@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursefee=" + coursefee
			+ ", courseDuration=" + courseDuration + "]";
}

}
