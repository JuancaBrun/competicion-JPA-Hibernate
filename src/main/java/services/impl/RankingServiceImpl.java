package services.impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Athlete;
import services.AthleteService;
import services.RankingService;

public class RankingServiceImpl implements RankingService {
	
	AthleteService atletaService = new AthleteServiceImpl();

	@Override
	public void showRanking(EntityManager em, Scanner sc) {

		showPrompt();
		manageOptions(em, sc);
	}

	private void manageOptions(EntityManager em, Scanner sc) {
		String ranking = sc.next();

		switch (ranking) {
		case "M":
			System.out.println("Ha seleccionado Masculino");
			getAthletesRanking(em, "Masculino", "Normal");
			break;
		case "F":
			System.out.println("Ha seleccionado Femenino");
			getAthletesRanking(em, "Femenino", "Normal");
			break;
		case "MM":
			System.out.println("Ha seleccionado Masculino Máster");
			getAthletesRanking(em, "Masculino", "Master");
			break;
		case "FM":
			System.out.println("Ha seleccionado Femenino Máster");
			getAthletesRanking(em, "Femenino", "Master");
			break;
		default:
			System.out.println("Opción inválida");
			break;
		}
	}

	private void showPrompt() {
		System.out.println(
				"Rankings disponibles: Masculino (M)\tFemenino(F)\tMasculino Máster 30(MM)\tFemenino Máster(FM)");
		System.out.print("Indica el ranking a consultar: ");
	}

	private void getAthletesRanking(EntityManager em, String genero, String rangoEdad) {

		String queryString = createQueryString(rangoEdad);

		try {
			List<Athlete> resultList = getAthletesFromDatabase(em, genero, queryString);
			showAthletesRanking(resultList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAthletesRanking(List<Athlete> resultList) {
		for (Athlete athlete : resultList) {
			System.out.print(athlete);
		}
	}

	private List<Athlete> getAthletesFromDatabase(EntityManager em, String genre, String queryString) {
		Query query = em.createQuery(queryString);
		query.setParameter("genero", genre);
		List<Athlete> resultList = query.getResultList();
		return resultList;
	}

	private String createQueryString(String ageRange) {
		String queryStr;
		if (ageRange == "Master") {
			queryStr = "SELECT a FROM Athlete a WHERE a.genre = :genero AND a.age >= 30";
		} else {
			queryStr = "SELECT a FROM Athlete a WHERE a.genre = :genero AND a.age < 30";
		}
		return queryStr;
	}

}
