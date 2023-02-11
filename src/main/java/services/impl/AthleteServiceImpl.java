package services.impl;

import java.util.Scanner;
import javax.persistence.EntityManager;

import com.microsoft.windowsazure.core.Builder.Alteration;

import dao.AthleteDao;
import dao.impl.AthleteDaoImpl;
import model.Athlete;
import services.AthleteService;
import services.RecordService;
import utils.AthleteUtil;

public class AthleteServiceImpl implements AthleteService {

	static RecordService recordService = new RecordServiceImpl();

	static AthleteDao athleteDao = new AthleteDaoImpl();

	@Override
	public void createAthlete(EntityManager em, Scanner sc) {

		Athlete newAthlete = AthleteUtil.buildAthlete(em, sc);

		if (athleteDao.create(em, newAthlete))
			recordService.checkIfNewRecord(em, newAthlete);
	}


	@Override
	public void readAthlete(EntityManager em, Scanner sc) {

		int id = AthleteUtil.getInputId(sc);

		Athlete athlete = athleteDao.read(em, id);

		if (athlete != null)
			System.out.print(athlete);
		else
			System.out.println("\nSin resultados para este ID\n");
	}

	@Override
	public void updateAthleteScore(EntityManager em, Scanner sc) {

		int id = AthleteUtil.getInputId(sc);

		Athlete originalAthlete = athleteDao.read(em, id);

		Athlete newAthlete = AthleteUtil.buildUpdatedAthlete(sc, originalAthlete);

		if (athleteDao.update(em, newAthlete))
			recordService.checkIfNewRecord(em, newAthlete);
		else
			System.out.println("\nEl atleta no se ha podido actualizar.");
	}


	@Override
	public void deleteAthlete(EntityManager em, Scanner sc) {

		int id = AthleteUtil.getInputId(sc);

		if (athleteDao.delete(em, id))
			System.out.println("\nEl atleta se ha borrado.");
		else
			System.out.println("\nEl atleta no se ha podido borrar.");

	}

}
