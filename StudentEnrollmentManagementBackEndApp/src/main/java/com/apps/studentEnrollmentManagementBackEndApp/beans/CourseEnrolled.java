package com.apps.studentEnrollmentManagementBackEndApp.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class CourseEnrolled {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
long courseEnrolledId;
	@JoinColumn(name = "courseId", foreignKey = @ForeignKey(name = "fk_course",
	foreignKeyDefinition = "FOREIGN KEY (courseId) REFERENCES Course(courseId)"))
private Long courseId;
	@JoinColumn(name = "studentId", foreignKey = @ForeignKey(name = "fk_student",
			foreignKeyDefinition = "FOREIGN KEY (studentId) REFERENCES Student(studentId)"))
private Long studentId;

public CourseEnrolled() {
	super();
	
}
public CourseEnrolled( Long courseId, Long studentId) {
	super();
	
	this.courseId = courseId;
	this.studentId = studentId;
}
public long getCourseEnrolledId() {
	return courseEnrolledId;
}
public Long getCourseId() {
	return courseId;
}
public void setCourseId(Long courseId) {
	this.courseId = courseId;
}
public Long getStudentId() {
	return studentId;
}
public void setStudentId(Long studentId) {
	this.studentId = studentId;
}
@Override
public String toString() {
	return "CourseEnrolled [courseEnrolledId=" + courseEnrolledId + ", courseId=" + courseId + ", studentId="
			+ studentId + "]";
}

}
