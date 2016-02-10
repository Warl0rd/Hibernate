package ru.sokolov.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.sokolov.hibernate.models.Student;
import ru.sokolov.hibernate.models.StudentAddress;
import ru.sokolov.hibernate.models.StudentDetail;
import ru.sokolov.hibernate.models.StudentSertification;

public class Main {

	public static void main(String[] args) {
		//Student address
		StudentSertification studentSertification1 = new StudentSertification();
		studentSertification1.setCertification_name("Core Java Certification Exam");
		
		StudentSertification studentSertification2 = new StudentSertification();
		studentSertification2.setCertification_name("MySQL DB Certification Exam");
		
		StudentSertification studentSertification3 = new StudentSertification();
		studentSertification3.setCertification_name("Hibernate Certification Exam");
		
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setAddress_detail("Novosibirsk, Russia");
		
		//Student detail
		StudentDetail studentDetail1 = new StudentDetail();
		studentDetail1.setStudent_mobile_number("11111111111");
		
		StudentDetail studentDetail2 = new StudentDetail();
		studentDetail2.setStudent_mobile_number("22222222222");
		
		//Student
		Student student1 = new Student();
		student1.setName("Vladimir1");
		student1.setStudentDetail(studentDetail1);
		studentDetail1.setStudent(student1);
		student1.setStudentAddress(studentAddress);
		student1.getStudentSertifications().add(studentSertification1);
		student1.getStudentSertifications().add(studentSertification3);
		
		Student student2 = new Student();
		student2.setName("Vladimir2");
		student2.setStudentDetail(studentDetail2);
		studentDetail2.setStudent(student2);
		student2.setStudentAddress(studentAddress);
		student2.getStudentSertifications().add(studentSertification2);
		student2.getStudentSertifications().add(studentSertification3);
		
		studentAddress.getStudents().add(student1);
		studentAddress.getStudents().add(student2);
		
		studentSertification1.getStudents().add(student1);
		studentSertification2.getStudents().add(student2);
		studentSertification3.getStudents().add(student1);
		studentSertification3.getStudents().add(student2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(studentAddress);
//		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
