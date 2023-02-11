package services;

import java.util.Scanner;

import javax.persistence.EntityManager;

public interface RankingService {

	public void showRanking(EntityManager em, Scanner sc);
	
}
