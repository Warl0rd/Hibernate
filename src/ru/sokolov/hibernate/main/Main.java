package ru.sokolov.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.sokolov.hibernate.models.Student;
import ru.sokolov.hibernate.models.StudentDetail;

public class Main {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.setName("Vladimir2");
		
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("11111111111");
		
		studentDetail.setStudent(student);
		
		student.setStudentDetail(studentDetail);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
