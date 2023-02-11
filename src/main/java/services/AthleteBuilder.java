package services;

import model.Athlete;

public interface AthleteBuilder {
	
	public AthleteBuilder setId(int id);
	
	public AthleteBuilder setFullName(String fullName);
	
	public AthleteBuilder setAge(int age);
	
	public AthleteBuilder setGenre(String genre);
	
	public AthleteBuilder setBenchPress(int benchPress);
	
	public AthleteBuilder setDeadLift(int deadLift);
	
	public AthleteBuilder setSquat(int squat);
	
	public AthleteBuilder setTotal(int total);
	
	public Athlete build();
	
}
