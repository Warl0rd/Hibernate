package ru.sokolov.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.sokolov.hibernate.models.Student;

public class Main {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.setName("Vladimir1");
		student.setRolNo(1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
