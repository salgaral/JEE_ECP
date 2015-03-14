package controllers;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class AddTemaController {
	
	private TemaDao temaDao;
	
	public AddTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}
	
	public void addTema(Tema tema){
		temaDao.create(tema);
	}
	
}
