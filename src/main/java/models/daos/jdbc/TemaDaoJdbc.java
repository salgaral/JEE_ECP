package models.daos.jdbc;

import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao{
	
	@Override
	public void create(Tema entity) {
		
	}

	@Override
	public Tema read(Integer id) {
		return null;
	}

	@Override
	public void update(Tema entity) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public List<Tema> findAll() {
		return null;
	}

	public static String sqlToCreateTable() {
		return null;
	}

}
