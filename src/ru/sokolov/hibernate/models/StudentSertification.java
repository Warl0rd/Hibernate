package ru.sokolov.hibernate.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTSERTIFICATIONS")
public class StudentSertification {
	
	@Id
	@GeneratedValue
	private int certification_id;
	
	private String certification_name;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="studentSertifications")
	private Set<Student> students = new HashSet<>(0);

	public int getCertification_id() {
		return certification_id;
	}

	public void setCertification_id(int certification_id) {
		this.certification_id = certification_id;
	}

	public String getCertification_name() {
		return certification_name;
	}

	public void setCertification_name(String certification_name) {
		this.certification_name = certification_name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
