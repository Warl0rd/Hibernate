package ru.sokolov.hibernate.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class Student {
	
	@Id
	@GeneratedValue
	private int student_id;
	
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentDetail studentDetail;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private StudentAddress studentAddress;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<StudentSertification> studentSertifications = new HashSet<>(0);
	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	public StudentAddress getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Set<StudentSertification> getStudentSertifications() {
		return studentSertifications;
	}

	public void setStudentSertifications(Set<StudentSertification> studentSertifications) {
		this.studentSertifications = studentSertifications;
	}
}
