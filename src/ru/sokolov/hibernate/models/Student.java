package ru.sokolov.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class Student {
	
	@Id
	@Column(name="No")
	private int rolNo;
	
	@Column(name="NAME")
	private String name;

	public int getRolNo() {
		return rolNo;
	}

	public void setRolNo(int rolNo) {
		this.rolNo = rolNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
