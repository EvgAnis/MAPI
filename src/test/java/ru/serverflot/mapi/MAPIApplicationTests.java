package ru.serverflot.mapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MAPIApplicationTests {

	@Test
	public void insertPaper(Paper paper) {
		PaperRepository paperRepository;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Paper");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Paper s1 = new Paper();
		s1.setClose(5.4);

		em.persist(s1);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}

	@Test
	public void contextLoads() {
	}

}
