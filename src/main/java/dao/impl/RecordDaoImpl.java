package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.RecordDao;
import model.Athlete;
import model.Record;

public class RecordDaoImpl implements RecordDao {

	@Override
	public Record readByAgeAndGenre(EntityManager em, Athlete athlete) {
		Query queryRecord = em.createQuery("SELECT r FROM Record r WHERE genre = :genre AND category = :category");

		queryRecord.setParameter("genre", athlete.getGenre());
		queryRecord.setParameter("category", (athlete.getAge() < 30 ? "Normal" : "Máster"));

		Record previousRecord = (Record) queryRecord.getResultList().get(0);
		return previousRecord;
	}

	@Override
	public boolean update(EntityManager em, Record newRecord) {
		boolean isSuccess = false;
		try {
			em.getTransaction().begin();
			em.merge(newRecord);
			em.getTransaction().commit();
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
