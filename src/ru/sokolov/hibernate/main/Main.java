package ru.sokolov.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.sokolov.hibernate.models.Student;
import ru.sokolov.hibernate.models.StudentDetail;

public class Main {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.setName("Vladimir1");
		
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("01234567890");
		
		studentDetail.setStudent(student);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(studentDetail);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
