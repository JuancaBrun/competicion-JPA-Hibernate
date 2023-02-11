package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Records")
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Genre")
	private String genre;

	@Column(name = "Category")
	private String category;

	@Column(name = "BenchPress")
	private int benchPress;

	@Column(name = "DeadLift")
	private int deadLift;

	@Column(name = "Squat")
	private int squat;

	@Column(name = "Total")
	private int total;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

}
