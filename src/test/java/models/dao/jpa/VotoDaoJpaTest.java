package models.dao.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pruebas.JpaFactory;

public class VotoDaoJpaTest {

	private VotoDao dao;

    private Voto voto, voto2;
    
    private List<Voto> votos;
	
	@BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        JpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
    	
    	dao = DaoJpaFactory.getFactory().getVotoDao();
    	
    	voto = new Voto("186.232.18.4", 8, NivelEstudio.Secundaria);
    	voto2 = new Voto("186.27.162.8", 5, NivelEstudio.Universitario);
    	
    	dao.create(voto);
    	dao.create(voto2);
    	
    	votos = new ArrayList<Voto>();
    	
    	votos.add(voto);
    	votos.add(voto2);
    }

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		assertEquals(voto, dao.read(voto.getId()));
	}

	@Test
	public void testUpdate() {
		voto.setName("other");
        voto.setPassword("other");
        voto.getAddress().setCity("other");
        voto.getAddress().setStreet("other");
        voto.getCategory().setName("other");
        voto.getCategory().setDescription("other");
        dao.update(voto);
        assertEquals(voto, dao.read(voto.getId()));
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(voto.getId());
        assertNull(dao.read(voto.getId()));
        assertNull(DaoFactory.getFactory().getVotoDao().read(voto.getCategory().getId()));
	}

	@Test
	public void testFindAll() {
		this.voto = new Tema("user", "pass", new Address("city", "street"));
        this.voto.setCategory(new Voto(333, "333", "333"));
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(voto);
        assertEquals(2, dao.findAll().size());
	}
	
	@After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
