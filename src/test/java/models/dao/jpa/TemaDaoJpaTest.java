package models.dao.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
	
	private TemaDao tDao;
	
	private Voto voto, voto2;

    private Tema tema, tema2;
    
    private List <Tema> temas;
    private List <Voto> votos;
	
	@BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        JpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
    	
    	tDao = DaoFactory.getFactory().getTemaDao();
    	
    	voto = new Voto("186.232.18.4", 8, NivelEstudio.Secundaria);
    	voto2 = new Voto("186.27.162.8", 5, NivelEstudio.Universitario);
    	
    	votos = new ArrayList<Voto>();
    	votos.add(voto);
    	votos.add(voto2);
    	
    	tema = new Tema("nombreTema1", "pregunta1");
    	tema2 = new Tema("nombreTema2", "pregunta2");
    	
    	tema.asignarVotos(votos);
    	tDao.create(tema);
    	tDao.create(tema2);
    	
    	temas = new ArrayList<Tema>();
    	temas.add(tema);
    	temas.add(tema2);
    }
	
	@Test
	public void testCreate() {
		
		Tema t1 = new Tema("nombrePreguntaCreada", "Pregunta Creada");
		
		tDao.create(t1);
		assertEquals(t1, tDao.read(t1.getId()));
	}

	@Test
	public void testRead() {
		assertEquals(tema, tDao.read(tema.getId()));
	}

	@Test
	public void testUpdate() {
		tema.setNombreTema("nombreTemaUpdate");
		tema.setPregunta("Pregunta Update");
        tDao.update(tema);
        Tema t2 = tDao.read(tema.getId());
        assertEquals(t2.getNombreTema(), "nombreTemaUpdate");
        assertEquals(t2.getPregunta(), "Pregunta Update");
	}

	@Test
	public void testDeleteById() {
		
		Tema t3 = new Tema();
		tDao.create(t3);
		tDao.deleteById(t3.getId());
        assertNull(tDao.read(t3.getId()));
	}

	@Test
	public void testFindAll() {
		assertEquals(temas, tDao.findAll());
	}
	
	@After
    public void after() {
		JpaFactory.dropAndCreateTables();
    }

}
