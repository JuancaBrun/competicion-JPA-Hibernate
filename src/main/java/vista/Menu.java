package vista;

import java.util.Scanner;

import javax.persistence.EntityManager;

import services.RankingService;
import services.impl.AthleteServiceImpl;
import services.impl.RankingServiceImpl;
import services.AthleteService;

public class Menu {

	
	static AthleteService athleteService = new AthleteServiceImpl();
	
	static RankingService rankingService = new RankingServiceImpl();
	
	public static void execMenu(EntityManager em) {
		
		String option;
		Scanner sc = new Scanner(System.in);
		do {
			option = showPrompt(sc);
			manageOptions(em, sc, option);
		} while (option != "6");
		sc.close();
		
	}

	private static void manageOptions(EntityManager em, Scanner sc, String opcion) {
		
		switch (opcion) {
		case "1":
			System.out.println("Ha seleccionado Introducir atleta");
			athleteService.createAthlete(em, sc);
			break;
		case "2":
			System.out.println("Ha seleccionado Revisar clasificación");
			rankingService.showRanking(em, sc);
			break;
		case "3":
			System.out.println("Ha seleccionado Buscar atleta");
			athleteService.readAthlete(em, sc);
			break;
		case "4":
			System.out.println("Ha seleccionado Eliminar atleta");
			athleteService.deleteAthlete(em, sc);
			break;
		case "5":
			System.out.println("Ha seleccionado Modificar puntuación");
			athleteService.updateAthleteScore(em, sc);
			break;
		case "6":
			System.out.println("Gracias por usar el programa");
			break;
		default:
			System.out.println("Opción inválida");
		}
	}

	private static String showPrompt(Scanner sc) {
		System.out.println("\n\n1. Introducir atleta");
		System.out.println("2. Revisar clasificación");
		System.out.println("3. Buscar atleta");
		System.out.println("4. Eliminar atleta");
		System.out.println("5. Modificar puntuación");
		System.out.println("6. Salir");
		System.out.print("Seleccione una opción: ");
		return sc.next();
	}
}