package com.apps.studentEnrollmentManagementBackEndApp.serviceImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apps.studentEnrollmentManagementBackEndApp.beans.CourseEnrolled;
import com.apps.studentEnrollmentManagementBackEndApp.dbConfig.Dbconfig;
import com.apps.studentEnrollmentManagementBackEndApp.service.CourseEnrolledService;

public class CourseEnrolledServiceImpl implements CourseEnrolledService {
	private Transaction transaction;
	private Session session;
	private Dbconfig dbconfig;
	public CourseEnrolledServiceImpl() {
		dbconfig = Dbconfig.getDbconfig();
	 
 }
	@Override
	public CourseEnrolled saveCourseEnrolled(CourseEnrolled courseEnrolled) {
		transaction = null;
		session = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the courseEnrolled object
			session.persist(courseEnrolled);
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
		return courseEnrolled;
		}

	@Override
	public CourseEnrolled getCourseEnrolledById(long courseEnrolledId) {
		transaction = null;
		session = null;
		CourseEnrolled courseEnrolled = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// find the courseEnrolled object
			courseEnrolled = session.find(CourseEnrolled.class, courseEnrolledId);
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
		return courseEnrolled ;
	}


	@Override
	public CourseEnrolled deleteCourseEnrolled(long courseEnrolledId) {
		transaction = null;
		session = null;
		CourseEnrolled courseEnrolled = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// delete the courseEnrolled object
			courseEnrolled = getCourseEnrolledById(courseEnrolledId);
			session.remove(courseEnrolled);
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
		return courseEnrolled;
	}

	@Override
	public CourseEnrolled updateCourseEnrolled(CourseEnrolled courseEnrolled) {
		transaction = null;
		session = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// update the courseEnrolled object
			session.update("CourseEnrolled", courseEnrolled);
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
		return courseEnrolled;
	}

	@Override
	public List<CourseEnrolled> getCourseEnrolled() {
		transaction = null;
		session = null;
		List<CourseEnrolled> courseEnrolled = null;
		try {
			session = dbconfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get list of courseEnrolleds
			courseEnrolled = (List<CourseEnrolled>) session.createQuery("from CourseEnrolled").list();
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
		return courseEnrolled;
	}
	

}
