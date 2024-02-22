package com.apps.studentEnrollmentManagementBackEndApp;

import java.util.Scanner;

import com.apps.studentEnrollmentManagementBackEndApp.beans.Course;
import com.apps.studentEnrollmentManagementBackEndApp.beans.CourseEnrolled;
import com.apps.studentEnrollmentManagementBackEndApp.beans.Student;
import com.apps.studentEnrollmentManagementBackEndApp.service.CourseEnrolledService;
import com.apps.studentEnrollmentManagementBackEndApp.service.CourseService;
import com.apps.studentEnrollmentManagementBackEndApp.service.StudentService;
import com.apps.studentEnrollmentManagementBackEndApp.serviceImpl.CourseEnrolledServiceImpl;
import com.apps.studentEnrollmentManagementBackEndApp.serviceImpl.CourseServiceImpl;
import com.apps.studentEnrollmentManagementBackEndApp.serviceImpl.StudentServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choose the table you want to operate on:"); 
            System.out.println("1: Student, 2: Course, 3: CourseEnrollment, 4: Exit");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    handleStudentOperations(sc);
                    break;
                case 2:
                    handleCourseOperations(sc);
                    break;
                case 3:
                    handleCourseEnrollmentOperations(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input, please choose a correct option.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void handleStudentOperations(Scanner sc) {
        StudentService studentService = new StudentServiceImpl();
        System.out.println("(Student Table) Enter 1: insert, 2: Get data by Id, 3: update, 4: delete, 5: Display Table");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter name:");
                String name = sc.next();
                System.out.println("Enter Age:");
                int age = sc.nextInt();
                System.out.println("Enter Gender:");
                String gender = sc.next();
                System.out.println(studentService.saveStudent(new Student(name, age, gender)));
                break;
            case 2:
                System.out.println("Enter Student id:");
                int id = sc.nextInt();
                System.out.println(studentService.getStudentById((long) id));
                break;
            case 3:
                System.out.println("Enter id for update:");
                int idno = sc.nextInt();
                Student student = studentService.getStudentById((long) idno);
                System.out.println("Enter name for update:");
                String updateName = sc.next();
                student.setStudentName(updateName);
                System.out.println(studentService.updateStudent(student));
                break;
            case 4:
                System.out.println("Enter id for delete:");
                int idForDelete = sc.nextInt();
                System.out.println(studentService.deleteStudent((long) idForDelete));
                break;
            case 5:
                System.out.println(studentService.getStudent()); // Assuming getStudent() should be getStudents() for fetching all students
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private static void handleCourseOperations(Scanner sc) {
        CourseService courseService = new CourseServiceImpl();
        System.out.println("(Course Table) Enter 1: insert, 2: Get data by Id, 3: update, 4: delete, 5: Display Table");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter courseName:");
                String courseName = sc.next();
                System.out.println("Enter coursefee:");
                double courseFee = sc.nextDouble();
                System.out.println("Enter courseDuration:");
                int courseDuration = sc.nextInt();
                System.out.println(courseService.saveCourse(new Course(courseName, courseFee, courseDuration)));
                break;
            case 2:
                System.out.println("Enter Course id:");
                long id = sc.nextLong();
                System.out.println(courseService.getCourseById(id));
                break;
            case 3:
                System.out.println("Enter id for update:");
                long idNo = sc.nextLong();
                Course course = courseService.getCourseById(idNo);
                System.out.println("Enter name for update:");
                String updateName = sc.next();
                course.setCourseName(updateName);
                System.out.println(courseService.updateCourse(course));
                break;
            case 4:
                System.out.println("Enter id for delete:");
                long idForDelete = sc.nextLong();
                System.out.println(courseService.deleteCourse(idForDelete));
                break;
            case 5:
                System.out.println(courseService.getCourse()); // Assuming getCourse() should be getCourses() for fetching all courses
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private static void handleCourseEnrollmentOperations(Scanner sc) {
        CourseEnrolledService courseEnrolledService = new CourseEnrolledServiceImpl();
        System.out.println("(CourseEnrolled Table) Enter 1: insert, 2: Get data by Id, 3: update, 4: delete, 5: Display Table");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter courseId:");
                long courseId = sc.nextLong();
                System.out.println("Enter studentId:");
                long studentId = sc.nextLong();
                System.out.println(courseEnrolledService.saveCourseEnrolled(new CourseEnrolled(courseId, studentId)));
                break;
            case 2:
                System.out.println("Enter Enrollment id:");
                long id = sc.nextLong();
                System.out.println(courseEnrolledService.getCourseEnrolledById(id));
                break;
            case 3:
                System.out.println("Enter id for update:");
                long idNo = sc.nextLong();
                CourseEnrolled courseEnrolled = courseEnrolledService.getCourseEnrolledById(idNo);
                System.out.println("Enter new courseId for update:");
                long newCourseId = sc.nextLong();
                courseEnrolled.setCourseId(newCourseId); // Assuming you want to update the courseId
                System.out.println(courseEnrolledService.updateCourseEnrolled(courseEnrolled));
                break;
            case 4:
                System.out.println("Enter id for delete:");
                long idForDelete = sc.nextLong();
                System.out.println(courseEnrolledService.deleteCourseEnrolled(idForDelete));
                break;
            case 5:
                System.out.println(courseEnrolledService.getCourseEnrolled()); // Assuming getCourseEnrolled() should be getCourseEnrollments() for fetching all enrollments
                break;
            default:
                System.out.println("Invalid input");
        }
    }
    }

