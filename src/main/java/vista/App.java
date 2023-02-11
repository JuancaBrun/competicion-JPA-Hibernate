package vista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import utils.JPAUtil;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Menu.execMenu(em);
		em.close();
		JPAUtil.shutdown();
	}
}
