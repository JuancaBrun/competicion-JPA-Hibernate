package utils;

import java.util.Scanner;

import javax.persistence.EntityManager;

import model.Athlete;
import services.impl.AthleteBuilderImpl;

public class AthleteUtil {

	public static int getInputId(Scanner sc) {
		System.out.print("Indica el ID del Atleta: ");
		int id = Integer.parseInt(sc.next());
		return id;
	}

	public static String getInputFullName(Scanner sc) {
		System.out.print("Indica el nombre completo del Atleta: ");
		String fullName = sc.next();
		return fullName;
	}

	public static String getInputGenre(Scanner sc) {
		System.out.print("Indica el género del Atleta: ");
		String genre = sc.next();
		return genre;
	}

	public static int getInputAge(Scanner sc) {
		System.out.print("Indica la edad del Atleta: ");
		int age = Integer.parseInt(sc.next());
		return age;
	}

	public static int getInputSquatScore(Scanner sc) {
		System.out.print("Indica la puntuación en Sentadilla del Atleta: ");
		int squatScore = Integer.parseInt(sc.next());
		return squatScore;
	}

	public static int getInputDeadLiftScore(Scanner sc) {
		System.out.print("Indica la puntuación en Peso Muerto del Atleta: ");
		int deadLiftScore = Integer.parseInt(sc.next());
		return deadLiftScore;
	}

	public static int getInputBenchPressScore(Scanner sc) {
		System.out.print("Indica la puntuación en Press Banca del Atleta: ");
		int benchPressScore = Integer.parseInt(sc.next());
		return benchPressScore;
	}

	public static int sumTotalScore(int benchPressScore, int deadLiftScore, int squatScore) {
		return benchPressScore + deadLiftScore + squatScore;
	}

	public static Athlete buildAthlete(EntityManager em, Scanner sc) {
		String fullName = AthleteUtil.getInputFullName(sc);
		int age = AthleteUtil.getInputAge(sc);
		String genre = AthleteUtil.getInputGenre(sc);
		int benchPress = AthleteUtil.getInputBenchPressScore(sc);
		int deadLift = AthleteUtil.getInputDeadLiftScore(sc);
		int squat = AthleteUtil.getInputSquatScore(sc);
		int total = AthleteUtil.sumTotalScore(benchPress, deadLift, squat);

		return new AthleteBuilderImpl().setFullName(fullName).setAge(age).setGenre(genre).setBenchPress(benchPress)
				.setDeadLift(deadLift).setSquat(squat).setTotal(total).build();
	}

	public static Athlete buildUpdatedAthlete(Scanner sc, Athlete originalAthlete) {
		int benchPress = AthleteUtil.getInputBenchPressScore(sc);
		int deadLift = AthleteUtil.getInputDeadLiftScore(sc);
		int squat = AthleteUtil.getInputSquatScore(sc);
		int total = AthleteUtil.sumTotalScore(benchPress, deadLift, squat);

		return new AthleteBuilderImpl().setId(originalAthlete.getId()).setFullName(originalAthlete.getFullName())
				.setAge(originalAthlete.getAge()).setGenre(originalAthlete.getGenre()).setBenchPress(benchPress)
				.setDeadLift(deadLift).setSquat(squat).setTotal(total).build();
	}
}
