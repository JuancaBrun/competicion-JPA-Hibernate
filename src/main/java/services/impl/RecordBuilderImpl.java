package services.impl;

import model.Record;
import services.RecordBuilder;

public class RecordBuilderImpl implements RecordBuilder {
	
	Record record = new Record();

	@Override
	public RecordBuilder setCategory(String category) {
		record.setCategory(category);
		return this;
	}

	@Override
	public RecordBuilder setGenre(String genre) {
		record.setGenre(genre);
		return this;
	}

	@Override
	public RecordBuilder setBenchPress(int benchPressScore) {
		record.setBenchPress(benchPressScore);
		return this;
	}

	@Override
	public RecordBuilder setDeadLift(int deadLiftScore) {
		record.setDeadLift(deadLiftScore);
		return this;
	}

	@Override
	public RecordBuilder setSquat(int squatScore) {
		record.setSquat(squatScore);
		return this;
	}

	@Override
	public RecordBuilder setTotal(int totalScore) {
		record.setTotal(totalScore);
		return this;
	}

	@Override
	public Record build() {
		return record;
	}

	

}
