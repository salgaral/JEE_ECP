package controllers;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;

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
	
	public Tema buscarPregunta(Integer id) {
		return temaDao.read(id);
	}
	
	public void addVoto(Integer idTema, Voto voto){
		votoDao.create(voto);
		Tema tema = temaDao.read(idTema);
		tema.getVotos().add(voto);
		temaDao.update(tema);
	}
	
}
