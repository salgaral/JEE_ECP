package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao{

	private Logger log = LogManager.getLogger(TemaDaoJdbc.class);
	
	private Tema create(ResultSet resultSet) {
        Tema Tema;
        try {
            if (resultSet != null && resultSet.next()) {
                Tema = new Tema(resultSet.getString(Tema.NAME), resultSet.getString(Tema.PASSWORD),
                        new Address(resultSet.getString(Address.CITY),
                                resultSet.getString(Address.STREET)));
                Tema.setId(resultSet.getInt(Tema.ID));
                // Reconstruir Category
                Integer categoryId = resultSet.getInt(Tema.CATEGORY);
                if (categoryId > 0) {
                    Category category = DaoFactory.getFactory().getCategoryDao().read(categoryId);
                    Tema.setCategory(category);
                }
                return Tema;
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s VARCHAR(255), %s VARCHAR(255), %s VARCHAR(255), %s INT, PRIMARY KEY (%s), "
            + "FOREIGN KEY(%s) REFERENCES %s(ID) )";

    public static String sqlToCreateTable() {
        return String
                .format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.NAME, Tema.PASSWORD, Address.CITY,
                        Address.STREET, Tema.CATEGORY, Tema.ID, Tema.CATEGORY, Category.TABLE);
    }

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s,%s) VALUES ('%s','%s','%s','%s',%d)";
	
	
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

}
