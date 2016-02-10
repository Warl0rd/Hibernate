package ru.sokolov.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.sokolov.hibernate.models.Student;
import ru.sokolov.hibernate.models.StudentAddress;
import ru.sokolov.hibernate.models.StudentDetail;

public class Main {

	public static void main(String[] args) {
		//Student address
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
		
		Student student2 = new Student();
		student2.setName("Vladimir2");
		student2.setStudentDetail(studentDetail2);
		studentDetail2.setStudent(student2);
		student2.setStudentAddress(studentAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
