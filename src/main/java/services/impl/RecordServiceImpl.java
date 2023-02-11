package services.impl;

import javax.persistence.EntityManager;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import model.Athlete;
import model.Record;
import services.RecordBuilder;
import services.RecordService;

public class RecordServiceImpl implements RecordService {

	private static RecordDao recordDao = new RecordDaoImpl();

	@Override
	public void checkIfNewRecord(EntityManager em, Athlete athlete) {

		Record recordForThisAgeAndGenre = recordDao.readByAgeAndGenre(em, athlete);

		if (recordForThisAgeAndGenre == null) {
			RecordBuilder recordBuilder = new RecordBuilderImpl();
			recordBuilder.setCategory(athlete.getAge() < 30 ? "Normal" : "Máster").setGenre(athlete.getGenre())
					.setDeadLift(athlete.getDeadLift()).setSquat(athlete.getSquat()).setTotal(athlete.getTotal())
					.build();

		} else {

			checkIfBenchPressRecord(athlete, recordForThisAgeAndGenre);
			checkIfDeadLiftRecord(athlete, recordForThisAgeAndGenre);
			checkIfSquatRecord(athlete, recordForThisAgeAndGenre);
			checkIfTotalRecord(athlete, recordForThisAgeAndGenre);

		}
		recordDao.update(em, recordForThisAgeAndGenre);

	}

	@Override
	public void checkIfBenchPressRecord(Athlete athlete, Record record) {
		if (athlete.getBenchPress() > record.getBenchPress())
			record.setBenchPress(athlete.getBenchPress());
	}

	@Override
	public void checkIfDeadLiftRecord(Athlete athlete, Record record) {
		if (athlete.getDeadLift() > record.getDeadLift())
			record.setDeadLift(athlete.getDeadLift());
	}

	@Override
	public void checkIfSquatRecord(Athlete nuevoAtleta, Record record) {
		if (nuevoAtleta.getSquat() > record.getSquat())
			record.setSquat(nuevoAtleta.getSquat());
	}

	@Override
	public void checkIfTotalRecord(Athlete nuevoAtleta, Record record) {
		if (nuevoAtleta.getTotal() > record.getTotal())
			record.setTotal(nuevoAtleta.getTotal());
	}
}
