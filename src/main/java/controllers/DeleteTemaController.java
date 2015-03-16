package controllers;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class DeleteTemaController {

	private TemaDao temaDao;
	
	public DeleteTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}
	
	public List<Tema> listarTemas(){
		return temaDao.findAll();
	}
	
	public void deleteTema(int id){
		System.out.println("El id que llega al controlador es: " + id);
		temaDao.deleteById(id);
	}
}
