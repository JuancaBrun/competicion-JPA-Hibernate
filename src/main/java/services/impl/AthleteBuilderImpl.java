package services.impl;

import model.Athlete;
import services.AthleteBuilder;

public class AthleteBuilderImpl implements AthleteBuilder {
	

	private Athlete atleta = new Athlete();

	@Override
	public AthleteBuilder setId(int id) {
		atleta.setId(id);
		return this;
	}

	@Override
	public AthleteBuilder setFullName(String fullName) {
		atleta.setFullName(fullName);
		return this;
	}

	@Override
	public AthleteBuilder setAge(int age) {
		atleta.setAge(age);
		return this;
	}

	@Override
	public AthleteBuilder setGenre(String genre) {
		atleta.setGenre(genre);
		return this;
	}

	@Override
	public AthleteBuilder setBenchPress(int benchPress) {
		atleta.setBenchPress(benchPress);
		return this;
	}

	@Override
	public AthleteBuilder setDeadLift(int deadLift) {
		atleta.setDeadLift(deadLift);
		return this;
	}

	@Override
	public AthleteBuilder setSquat(int squat) {
		atleta.setSquat(squat);
		return this;
	}

	@Override
	public AthleteBuilder setTotal(int total) {
		atleta.setTotal(total);
		return this;
	}


	@Override
	public Athlete build() {
		return atleta;
	}

}
