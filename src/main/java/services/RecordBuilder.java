package services;

import model.Record;

public interface RecordBuilder {

	public RecordBuilder setCategory(String category);
	
	public RecordBuilder setGenre(String genre);
	
	public RecordBuilder setBenchPress(int benchPressScore);
	
	public RecordBuilder setDeadLift(int deadLiftScore);
	
	public RecordBuilder setSquat(int squatScore);
	
	public RecordBuilder setTotal(int totalScore);
	
	public Record build();
}
