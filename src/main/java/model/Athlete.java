package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Athlete")
public class Athlete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "Age")
	private int age;

	@Column(name = "Genre")
	private String genre;

	@Column(name = "BenchPress")
	private int benchPress;

	@Column(name = "DeadLift")
	private int deadLift;

	@Column(name = "Squat")
	private int squat;

	@Column(name = "Total")
	private int total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getBenchPress() {
		return benchPress;
	}

	public void setBenchPress(int benchPress) {
		this.benchPress = benchPress;
	}

	public int getDeadLift() {
		return deadLift;
	}

	public void setDeadLift(int deadLift) {
		this.deadLift = deadLift;
	}

	public int getSquat() {
		return squat;
	}

	public void setSquat(int squat) {
		this.squat = squat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {

		return String.format(
				"\nID: %-2s Nombre: %-15s Edad: %-3s Género: %-10s\nBench Press: %-5s Dead Lift: %-5s Squat: %-5s TOTAL: %-5s\n",
				this.getId(), this.getFullName(), this.getAge(), this.getGenre(), this.getBenchPress(),
				this.getDeadLift(), this.getSquat(), this.getTotal());
	}

}
