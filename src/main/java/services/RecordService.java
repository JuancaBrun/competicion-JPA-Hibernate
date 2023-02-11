package services;

import javax.persistence.EntityManager;

import model.Athlete;
import model.Record;

public interface RecordService {
	
	public void checkIfNewRecord(EntityManager em, Athlete athlete);

	public void checkIfBenchPressRecord(Athlete athlete,
			Record previousRecordForThisAgeAndGenre);
	
	public void checkIfDeadLiftRecord(Athlete athlete,
			Record previousRecordForThisAgeAndGenre);
	
	public void checkIfSquatRecord(Athlete athlete,
			Record previousRecordForThisAgeAndGenre);
	
	public void checkIfTotalRecord(Athlete athlete,
			Record previousRecordForThisAgeAndGenre);
}
