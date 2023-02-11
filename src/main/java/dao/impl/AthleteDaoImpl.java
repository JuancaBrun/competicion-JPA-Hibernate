package dao.impl;

import javax.persistence.EntityManager;

import dao.AthleteDao;
import model.Athlete;

public class AthleteDaoImpl implements AthleteDao {

	@SuppressWarnings("finally")
	@Override
	public boolean create(EntityManager em, Athlete newAthlete) {
		boolean isSucceed = false;
		try {
			em.getTransaction().begin();
			em.persist(newAthlete);
			em.getTransaction().commit();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return isSucceed;
		}
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public Athlete read(EntityManager em, int id) {
		Athlete atleta = null;
		try {
			atleta = em.find(Athlete.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return atleta;
		}
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public boolean update(EntityManager em, Athlete athlete) {
		boolean isSucceed = false;
		try {
			em.getTransaction().begin();
			em.merge(athlete);
			em.getTransaction().commit();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return isSucceed;
		}
	}


	@SuppressWarnings("finally")
	@Override
	public boolean delete(EntityManager em, int id) {
		boolean isSucceed = false;
		try {
			em.getTransaction().begin();
			Athlete atleta = em.find(Athlete.class, id);
			em.remove(atleta);
			em.getTransaction().commit();
			isSucceed = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return isSucceed;
		}
	}

}
