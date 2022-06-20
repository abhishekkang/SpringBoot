package com.tnsif.placement;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Placement {
	private Integer id;
	private LocalDate date;
	private String name, college,qualification;
	private int year;
	public Placement() {
}
	public Placement(Integer id, LocalDate date, String name, String college, String qualification, int year) {
		this.id = id;
		this.date = date;
		this.name = name;
		this.college = college;
		this.qualification = qualification;
		this.year = year;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Placement [id=" + id + ", date=" + date + ", name=" + name + ", college=" + college + ", qualification="
				+ qualification + ", year=" + year + "]";
	}
	
	
}
