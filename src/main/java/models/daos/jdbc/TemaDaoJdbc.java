package models.daos.jdbc;

import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao{
	
	@Override
	public void create(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String sqlToCreateTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
