package models.dao.jpa;

import static org.junit.Assert.*;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoDaoJpaTest {

	private TemaDao dao;

    private Tema tema;
	
	@BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.tema = new Tema("user", "pass", new Address("city", "street"));
        this.tema.setCategory(new Category(666, "666", "666"));
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
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
		tema.setName("other");
        tema.setPassword("other");
        tema.getAddress().setCity("other");
        tema.getAddress().setStreet("other");
        tema.getCategory().setName("other");
        tema.getCategory().setDescription("other");
        dao.update(tema);
        assertEquals(tema, dao.read(tema.getId()));
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
        assertNull(DaoFactory.getFactory().getCategoryDao().read(tema.getCategory().getId()));
	}

	@Test
	public void testFindAll() {
		this.tema = new Tema("user", "pass", new Address("city", "street"));
        this.tema.setCategory(new Category(333, "333", "333"));
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
        assertEquals(2, dao.findAll().size());
	}
	
	@After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
