package dao;

import javax.persistence.EntityManager;

import model.Athlete;
import model.Record;

public interface RecordDao {

	public Record readByAgeAndGenre(EntityManager em, Athlete athlete);

	public boolean update(EntityManager em, Record newRecord);
}
