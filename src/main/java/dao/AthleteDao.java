package dao;

import javax.persistence.EntityManager;

import model.Athlete;
import model.Record;

public interface AthleteDao {
	
	public boolean create(EntityManager em, Athlete newAthlete);
	
	public Athlete read(EntityManager em, int id);

	public boolean update(EntityManager em, Athlete athlete);

	public boolean delete(EntityManager em, int id);
}
