package com.apps.studentEnrollmentManagementBackEndApp.service;

import java.util.List;

import com.apps.studentEnrollmentManagementBackEndApp.beans.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public Student getStudentById(long studentId);
	public Student deleteStudent(long studentId);
	public Student updateStudent(Student student);
	public List<Student> getStudent();
	

}
