package com.apps.studentEnrollmentManagementBackEndApp.serviceImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.apps.studentEnrollmentManagementBackEndApp.beans.Student;
import com.apps.studentEnrollmentManagementBackEndApp.dbConfig.Dbconfig;
import com.apps.studentEnrollmentManagementBackEndApp.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private Transaction transaction;
	private Session session;
	private Dbconfig dbconfig;
	public StudentServiceImpl() {
		dbconfig = Dbconfig.getDbconfig();
	}

	@Override
	public Student saveStudent(Student student) {
	
		transaction = null;
		session = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the student object
			session.persist(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return student;
	}

	@Override
	public Student getStudentById(long studentId) {
	
		transaction = null;
		session = null;
		Student student = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// find the student object
			student = session.find(Student.class, studentId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return student;
	}

	@Override
	public Student deleteStudent(long studentId) {
	
		transaction = null;
		session = null;
		Student student = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// delete the student object
			student = getStudentById(studentId);
			session.remove(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e);
		} finally {
			transaction = null;
			session = null;
		}
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
	
		transaction = null;
		session = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// update the student object
			session.update("Student", student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return student;
	}

	@Override
	public List<Student> getStudent() {
	
		transaction = null;
		session = null;
		List<Student> students = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get list of students
			students = (List<Student>) session.createQuery("from Student").list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return students;
	}

}
