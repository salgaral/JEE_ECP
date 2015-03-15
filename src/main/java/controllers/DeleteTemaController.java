package controllers;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class DeleteTemaController {

	private TemaDao temaDao;
	
	private int id;
	
	private List<T> lista;
	
	public DeleteTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}
	
	public void deleteTema(Tema tema){
		lista = temaDao.findAll();
		temaDao.deleteById(id);
	}
}
