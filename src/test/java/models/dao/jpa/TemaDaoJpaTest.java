package models.dao.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.jpa.JpaFactory;
import models.utils.NivelEstudio;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {
	
	private TemaDao dao;

    private Tema tema;
    
    private List <Tema> temas;
	
	@BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        JpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
    	dao = DaoFactory.getFactory().getTemaDao();
    	dao.create(tema);
    	
    	votos = new ArrayList <Voto>();
    	votos.add(new Voto("185.168.11.2", 3, NivelEstudio.Bachillerato));
    	votos.add(new Voto("185.168.27.3", 7, NivelEstudio.FormaciónProfesional));
        this.tema = new Tema("NombreTema", "Pregunta", votos);
    }
	
	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		assertEquals(tema, dao.read(tema.getId()));
	}

	@Test
	public void testUpdate() {
		//tema.setName("other");
		//tema.setPassword("other");
		//tema.getAddress().setCity("other");
		//tema.getAddress().setStreet("other");
		//tema.getCategory().setName("other");
		//tema.getCategory().setDescription("other");
        dao.update(tema);
        assertEquals(tema, dao.read(tema.getId()));
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
        //assertNull(DaoFactory.getFactory().getCategoryDao().read(tema.getCategory().getId()));
	}

	@Test
	public void testFindAll() {
		//this.tema = new Tema("user", "pass", new Address("city", "street"));
		//this.tema.setCategory(new Category(333, "333", "333"));
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
        assertEquals(2, dao.findAll().size());
	}
	
	@After
    public void after() {
		//DaoJpaFactory.dropAndCreateTables();
    }

}
