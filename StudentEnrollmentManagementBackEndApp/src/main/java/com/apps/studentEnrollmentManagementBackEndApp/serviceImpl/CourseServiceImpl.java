package com.apps.studentEnrollmentManagementBackEndApp.serviceImpl;

import java.util.List;

import com.apps.studentEnrollmentManagementBackEndApp.beans.Course;
import com.apps.studentEnrollmentManagementBackEndApp.beans.Student;
import com.apps.studentEnrollmentManagementBackEndApp.dbConfig.Dbconfig;
import com.apps.studentEnrollmentManagementBackEndApp.service.CourseService;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class CourseServiceImpl implements CourseService {
	private Transaction transaction;
	private Session session;
	private Dbconfig dbconfig;
	public CourseServiceImpl() {
		dbconfig = Dbconfig.getDbconfig();
 }
	@Override
	public Course saveCourse(Course course) {
		
		transaction = null;
		session = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the course object
			session.persist(course);
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
		return course;
	}

	@Override
	public Course getCourseById(long courseId) {
		
		transaction = null;
		session = null;
		Course course = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// find the course object
			course = session.find(Course.class, courseId);
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
		return course ;
	}

	@Override
	public Course deleteCourse(long courseId) {
		
		transaction = null;
		session = null;
		Course course = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// delete the course object
			course = getCourseById(courseId);
			session.remove(course);
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
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		transaction = null;
		session = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// update the course object
			session.update("Course", course);
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
		return course;
	}

	@Override
	public List<Course> getCourse() {
		
		transaction = null;
		session = null;
		List<Course> courses = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get list of courses
			courses = (List<Course>) session.createQuery("from Course").list();
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
		return courses;
	}

}
