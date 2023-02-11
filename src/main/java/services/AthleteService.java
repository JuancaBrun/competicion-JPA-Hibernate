package services;

import java.util.Scanner;

import javax.persistence.EntityManager;

public interface AthleteService {

	public void createAthlete(EntityManager em, Scanner sc);

	public void readAthlete(EntityManager em, Scanner sc);

	public void updateAthleteScore(EntityManager em, Scanner sc);

	public void deleteAthlete(EntityManager em, Scanner sc);

}
