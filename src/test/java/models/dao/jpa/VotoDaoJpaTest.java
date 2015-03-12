package models.dao.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Voto;
import models.jpa.JpaFactory;
import models.utils.NivelEstudio;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		
		Voto v1 = new Voto("186.23.17.1", 4, NivelEstudio.FormaciónProfesional);
		
		dao.create(v1);
		assertEquals(v1, dao.read(v1.getId()));
	}

	@Test
	public void testRead() {
		assertEquals(this.voto, dao.read(voto.getId()));
	}

	@Test
	public void testUpdate() {
		voto.setNivelestudio(NivelEstudio.Universitario);
		voto.setValor(3);
        dao.update(voto);
        Voto v2 = dao.read(voto.getId());
        assertEquals(v2.getNivelestudio(), NivelEstudio.Universitario);
        assertEquals((int)v2.getValor(), 3);
	}

	@Test
	public void testDeleteById() {
		Voto v3 = new Voto();
		dao.create(v3);
		dao.deleteById(v3.getId());
        assertNull(dao.read(v3.getId()));
	}

	@Test
	public void testFindAll() {
        assertEquals(votos, dao.findAll());
	}
	
	@After
    public void after() {
        JpaFactory.dropAndCreateTables();
    }

}
