package controllers;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class VotarController {
	
	private TemaDao temaDao;
	private VotoDao votoDao;
	
	
	public VotarController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}
	
	public List<Tema> listarTemas(){
		return temaDao.findAll();
	}

	public Tema buscarPregunta(String nombreTema) {
		return temaDao.buscarPregunta(nombreTema);
	}
	
}
